package ru.liga.service.api;


import ru.liga.dto.Dto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderRequest;
import ru.liga.dto.OrderResponse;

import java.util.Optional;

public interface OrderService {
    Dto getAllDto();
    Optional<OrderDto> getDtoById(Integer id);
    OrderResponse makeOrder(OrderRequest request);
}
