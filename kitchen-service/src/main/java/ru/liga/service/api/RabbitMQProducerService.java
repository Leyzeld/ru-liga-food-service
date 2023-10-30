package ru.liga.service.api;

public interface RabbitMQProducerService {
    void sendMessage(Long message, String routingKey);
}
