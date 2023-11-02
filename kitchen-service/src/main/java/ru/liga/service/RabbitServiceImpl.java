package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.model.MessageEntity;
import ru.liga.model.OrderEntity;
import ru.liga.service.api.OrderService;
import ru.liga.service.api.RabbitMQProducerService;
import ru.liga.service.api.RabbitService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RabbitServiceImpl implements RabbitService {

    private final RabbitMQProducerService rabbitMQProducerService;
    private final OrderService orderService;
    @Override
    public void sendMsg(MessageEntity messageEntity) {
        List<OrderEntity> orderEntity = orderService.getOrderByStatus("Заказ создан и ожидает курьера");
        if (orderEntity.size() != 0) {
            messageEntity.setOrderIdWithoutCourier(orderEntity.get(0).getId());
            messageEntity.setRoutingKey("myRoutingKey");
            rabbitMQProducerService.sendMessage(messageEntity.getOrderIdWithoutCourier(), messageEntity.getRoutingKey());
        } else {
            System.out.printf("Нет заказов без курьеров");
        }
    }
}
