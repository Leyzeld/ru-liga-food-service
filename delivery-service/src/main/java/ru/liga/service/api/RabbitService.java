package ru.liga.service.api;

import ru.liga.dto.OrderMessage;

import java.util.UUID;

public interface RabbitService {
    void sendDeliveryStatus(OrderMessage orderMessage, String routingKey);
    void sendDeliveryInfo(UUID orderId, String routingKey);
    void sendDeliveryComplete(OrderMessage orderMessage, String routingKey);
}
