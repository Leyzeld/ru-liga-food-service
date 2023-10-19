package ru.liga.service.api;

import ru.liga.model.OrderItemEntity;

import java.util.List;

public interface OrderItemService {
    public List<OrderItemEntity> showAll();
    public void addOrderItem(OrderItemEntity orderItemEntity);
    public void deleteOrderItemById(Integer id);
}
