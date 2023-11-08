package ru.liga.service.api;

import ru.liga.dto.OrderItemDto;
import ru.liga.model.OrderItemEntity;

import java.util.List;
import java.util.UUID;

public interface OrderItemService {

    public OrderItemDto getOrderItemById(Long id);
    public void setOrderItem(OrderItemEntity orderItemEntity);
    public void deleteOrderItemById (Long id);
    public List<OrderItemEntity> findOrderItemByOrderId (Long id);
}
