package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderMessage;
import ru.liga.repository.OrderRepository;
import ru.liga.service.api.DeliveryService;
import ru.liga.service.api.RabbitService;
import ru.liga.status.OrderStatus;

import java.util.UUID;

@EnableRabbit
@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {
    private final OrderRepository orderRepository;
    private final RabbitService rabbitService;
    @Override
    public void completeOrder(UUID orderId) {
        OrderMessage orderMessage = new OrderMessage(orderId, OrderStatus.DELIVERED.getStatus());
        orderRepository.updateStatus(orderId, orderMessage.getOrderStatus());
        rabbitService.sendDeliveryComplete(orderMessage, "deliveryCompleteToNotification");
    }
}
