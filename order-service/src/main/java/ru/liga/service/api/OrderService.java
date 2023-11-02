package ru.liga.service.api;


import ru.liga.orderDto.Dto;
import ru.liga.orderDto.OrderDto;
import ru.liga.orderDto.OrderRequest;
import ru.liga.orderDto.OrderResponse;

import java.util.Optional;

public interface OrderService {
    Dto getAllDto();
    Optional<OrderDto> getDtoById(Integer id);
    OrderResponse makeOrder(OrderRequest request);
}
