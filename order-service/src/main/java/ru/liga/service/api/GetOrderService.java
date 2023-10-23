package ru.liga.service.api;

import ru.liga.dto.GetOrderResponse;
import ru.liga.dto.OrderRequest;

import java.util.List;
import java.util.Optional;

public interface GetOrderService {
    public List<GetOrderResponse> getAllOrders();
    public GetOrderResponse getOrderById(Long id);
    public void addOrder(OrderRequest orderRequest, Long id);
}
