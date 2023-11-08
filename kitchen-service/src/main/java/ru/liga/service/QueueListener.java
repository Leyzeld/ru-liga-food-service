package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderMessage;

@EnableRabbit
@Service
@RequiredArgsConstructor
@Slf4j
public class QueueListener {
    @RabbitListener(queues = "newOrderToKitchen")
    public void handleNewOrder(OrderMessage orderAction) {
        log.info("Новый зказ id = {} со статусом = {} получен kitchen-service", orderAction.getOrderId(), orderAction.getOrderStatus());
    }
}
