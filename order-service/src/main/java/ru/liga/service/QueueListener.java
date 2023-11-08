package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderMessage;
import ru.liga.status.OrderStatus;

@EnableRabbit
@Service
@RequiredArgsConstructor
@Slf4j
public class QueueListener {

    @RabbitListener(queues = "kitchenToOrder")
    public void handleInfoFromKitchen(OrderMessage orderMessage) {
        if (orderMessage.getOrderStatus() == OrderStatus.ORDER_DECLINED.getStatus()) {
            log.info("Заказ id = {} статус = {} отменен", orderMessage.getOrderId(),
                    orderMessage.getOrderStatus());
        }
        log.info("Заказ id = {} статус ={} принят", orderMessage.getOrderId(),
                orderMessage.getOrderStatus());
    }
}
