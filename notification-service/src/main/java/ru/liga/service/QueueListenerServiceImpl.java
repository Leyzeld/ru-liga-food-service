package ru.liga.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderMessage;
import ru.liga.service.api.QueueListenerService;

import java.util.UUID;

import static ru.liga.queues.QueueNotifier.*;
import static ru.liga.queues.QueueListener.*;

@EnableRabbit
@Service
@RequiredArgsConstructor
@Slf4j
public class QueueListenerServiceImpl implements QueueListenerService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    @RabbitListener(queues = NEW_ORDER_QUEUE)
    public void getNewOrder(OrderMessage orderMessage) {
        rabbitTemplate.convertAndSend(ORDER_TO_KITCHEN, orderMessage);
        log.info("Заказ id = {} отправлен в restaurant-service", orderMessage.getOrderId());
    }
    @Override
    @RabbitListener(queues = {KITCHEN_ACCEPT_QUEUE, KITCHEN_DENIED_QUEUE})
    public void getKitchenAnswerForNewOrder(OrderMessage orderMessage) {
        rabbitTemplate.convertAndSend(KITCHEN_TO_ORDER_SERVICE, orderMessage);
        log.info("Заказ id = {} со статусом = {} отправлен в order-service", orderMessage.getOrderId(),
                orderMessage.getOrderStatus());
    }
    @Override
    @RabbitListener(queues = KITCHEN_COMPLETE_QUEUE)
    public void handleCompleteOrder(OrderMessage orderMessage) {
        rabbitTemplate.convertAndSend(KITCHEN_TO_ORDER_SERVICE, orderMessage);
        rabbitTemplate.convertAndSend(ORDER_TO_DELIVERY, orderMessage);
        log.info("Заказ id = {} со статусом = {} отправлен в delivery-services", orderMessage.getOrderId(),
                orderMessage.getOrderStatus());
    }
    @Override
    @RabbitListener(queues = {DELIVERY_TAKEN_QUEUE, DELIVERY_COMPLETE_QUEUE})
    public void handleDelivery(OrderMessage orderMessage) {
        rabbitTemplate.convertAndSend(DELIVERY_TO_ORDER, orderMessage);
        log.info("Заказ id = {} со статусом = {} отправлен в order-service", orderMessage.getOrderId(),
                orderMessage.getOrderStatus());
    }
    @Override
    @RabbitListener(queues = NOTIFY_COURIERS_QUEUE)
    public void handleNotifyCouriers(UUID orderId) {
        System.out.println("Зааказ id =" + orderId + " готов к доставке");
        log.info("Уведомление курьера о готовности заказа id={}", orderId);
    }
}