package ru.liga.batisMapper;

import ru.liga.model.OrderEntity;

import java.util.List;

public interface BatisMapper {
    List<OrderEntity> getOrderByStatus(String status);
    List<OrderEntity> getOrderById(Integer id);
    void updateOrderStatus(OrderEntity order);
}