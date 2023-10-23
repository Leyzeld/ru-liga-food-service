package ru.liga.service;

import lombok.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.service.api.RabbitMQProducerService;

@Data
@Service
public class RabbitMQProducerServiceImpl  implements RabbitMQProducerService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message, String routingKey) {
        rabbitTemplate.convertAndSend("msgKitchenCourier", routingKey, message);
    }
}
