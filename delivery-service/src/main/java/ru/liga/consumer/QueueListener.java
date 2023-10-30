package ru.liga.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.liga.service.FaingService;

@Component
@EnableRabbit
public class QueueListener {
    @RabbitListener(queues = "queue1")
    public Long processMyQueue(Long message) {
        FaingService.getCaseById(message);
        System.out.printf("Received from myQueue : %s ", message);
        return message;
    }
}
