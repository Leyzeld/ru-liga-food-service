package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.dto.OrderMessage;
import ru.liga.queues.DeliveryQueue;
import ru.liga.queues.ListenQueue;
import ru.liga.repository.OrderRepository;
import ru.liga.service.api.RabbitService;
import ru.liga.status.OrderStatus;

@EnableRabbit
@Service
@RequiredArgsConstructor
@Slf4j
public class QueueListener {
    private final RabbitService rabbitService;
    private final OrderRepository orderRepository;

    @RabbitListener(queues = ListenQueue.ORDER_TO_DELIVERY)
    @Transactional
    public void handleOrderToDelivery(OrderMessage orderMessage) {
        orderMessage.setOrderStatus(OrderStatus.WAITING_FOR_COURIER.getStatus());
        log.info("Заказ id = {} получен delivery-service", orderMessage.getOrderId());
        orderRepository.updateStatus(orderMessage.getOrderId(), orderMessage.getOrderStatus());
        rabbitService.sendDeliveryInfo(orderMessage.getOrderId(), DeliveryQueue.NOTIFY_COURIERS);
    }
}
