package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderMessage;
import ru.liga.service.api.RabbitService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitServiceImpl implements RabbitService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendDeliveryStatus(OrderMessage orderMessage, String routingKey) {
        rabbitTemplate.convertAndSend("directExchange", routingKey, orderMessage);
        log.info("Доставка заказа id = {} со статусом = {} отправлена в notification-service", orderMessage.getOrderId(),
                orderMessage.getOrderStatus());
    }

    @Override
    public void sendDeliveryInfo(UUID orderId, String routingKey) {
        rabbitTemplate.convertAndSend("directExchange", routingKey, orderId);
        log.info("Обновленная информация по заказу id={} отправлена в notification-service", orderId);
    }

    @Override
    public void sendDeliveryComplete(OrderMessage orderMessage, String routingKey) {
        rabbitTemplate.convertAndSend("directExchange", routingKey, orderMessage);
        log.info("Выдача заказа id = {} со статусом = {} отправлена в notification-service", orderMessage.getOrderId(),
                orderMessage.getOrderStatus());
    }
}
