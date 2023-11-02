package ru.liga.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.model.MessageEntity;
import ru.liga.model.OrderEntity;
import ru.liga.service.api.OrderService;
import ru.liga.service.api.RabbitMQProducerService;
import ru.liga.service.api.RabbitService;

import java.util.List;

@Tag(name = "API для службы доставки сообщений через rabbitMQ")
@RestController
@RequiredArgsConstructor
@RequestMapping("/rabbit")
public class RabbitController{
    private final RabbitService rabbitService;

    @GetMapping("/send")
    public void sendMessageToRabbit(@RequestBody MessageEntity messageEntity) {
        rabbitService.sendMsg(messageEntity);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
