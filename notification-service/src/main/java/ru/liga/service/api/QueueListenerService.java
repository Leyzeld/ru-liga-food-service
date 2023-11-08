package ru.liga.service.api;

import ru.liga.dto.OrderMessage;

import java.util.UUID;

public interface QueueListenerService {
    public void getNewOrder(OrderMessage orderMessage);
    public void getKitchenAnswerForNewOrder(OrderMessage orderMessage);
    public void handleCompleteOrder(OrderMessage orderMessage);
    public void handleDelivery(OrderMessage orderMessage);
    public void handleNotifyCouriers(UUID orderId);
}
