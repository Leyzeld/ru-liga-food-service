package ru.liga.service.api;

public interface RabbitMQProducerService {
    void sendMessage(String message, String routingKey);
}
