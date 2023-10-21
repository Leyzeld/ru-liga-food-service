package ru.liga.service.api;

import ru.liga.dto.Order;
import ru.liga.dto.OrderItem;
import ru.liga.model.OrderEntity;
import ru.liga.model.OrderItemEntity;

public interface OrderItemService {

    public OrderItem getOrderItemById(Long id);
    public void setOrderItem(OrderItemEntity orderItemEntity);
    public void deleteOrderItemById (Long id);
}
