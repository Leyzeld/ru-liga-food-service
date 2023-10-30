package ru.liga.service.api;

import ru.liga.dto.OrderDto;
import ru.liga.model.OrderEntity;

import java.util.List;

public interface OrderService {
    public OrderDto getOrderById(Long id);
    public void setOrder(OrderEntity orderEntity);
    List<OrderEntity> getOrderByStatus (String status);
}
