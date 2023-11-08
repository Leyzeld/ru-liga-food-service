package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
//import ru.liga.feign.DeliveryFeignClient;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.dto.OrderMessage;
import ru.liga.model.CourierEntity;
import ru.liga.model.OrderEntity;
import ru.liga.repository.OrderRepository;
import ru.liga.service.api.KitchenService;
import ru.liga.service.api.RabbitService;
import ru.liga.status.OrderStatus;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class KitchenServiceImpl implements KitchenService {
    private final RabbitService rabbitService;
    private final OrderRepository orderRepository;
    @Override
    public void acceptOrder(UUID id) {
        OrderMessage orderMessage = new OrderMessage(id, OrderStatus.ORDER_ACCEPTED.getStatus());
        orderRepository.updateStatus(id, orderMessage.getOrderStatus());
        rabbitService.sendNewOrder(orderMessage, "kitchenAcceptToNotification");
    }

    @Override
    public void declineOrder(UUID id) {
        OrderMessage orderMessage = new OrderMessage(id, OrderStatus.ORDER_DECLINED.getStatus());
        orderRepository.updateStatus(id, orderMessage.getOrderStatus());
        rabbitService.sendNewOrder(orderMessage, "kitchenDeniedToNotification");
    }

    @Override
    public void readyOrder(UUID id) {
        OrderMessage orderMessage = new OrderMessage(id, OrderStatus.WAITING_FOR_COURIER.getStatus());
        orderRepository.updateStatus(id, orderMessage.getOrderStatus());
        rabbitService.sendNewOrder(orderMessage, "kitchenDeniedToNotification");
    }
}
