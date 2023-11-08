package ru.liga.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderMessage;
import ru.liga.service.api.RabbitService;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitServiceImpl implements RabbitService {
    private final RabbitTemplate rabbitTemplate;
    public void sendNewOrder(OrderMessage orderMessage, String routingKey) {
        rabbitTemplate.convertAndSend("directExchange", routingKey, orderMessage);
        log.info("Заказ id = {} и статусом = {} был отправлен в NS", orderMessage.getOrderId(), orderMessage.getOrderStatus());
    }
}
