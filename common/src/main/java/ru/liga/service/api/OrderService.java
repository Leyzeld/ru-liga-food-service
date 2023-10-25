package ru.liga.service.api;

import ru.liga.dto.Order;
import ru.liga.model.OrderEntity;

public interface OrderService {
    public Order getOrderById(Long id);
    public void setOrder(OrderEntity orderEntity);
}
