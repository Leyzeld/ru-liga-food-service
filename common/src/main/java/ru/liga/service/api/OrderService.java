package ru.liga.service.api;

import ru.liga.dto.OrderDto;
import ru.liga.model.CourierEntity;
import ru.liga.model.OrderEntity;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    public OrderDto getOrderById(UUID id);
    public void setOrder(OrderEntity orderEntity);
    List<OrderEntity> getOrderByStatus (String status);
    void setCourier (Long courierId, UUID id);
}
