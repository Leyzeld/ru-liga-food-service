package ru.liga.service.api;

import ru.liga.dto.OrderMessage;

public interface RabbitService {
    void sendNewOrder(OrderMessage orderMessage, String routingKey);
}
