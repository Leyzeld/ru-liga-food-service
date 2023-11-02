package ru.liga.service.api;

import ru.liga.dto.OrderViewResponse;
import ru.liga.dto.OrderRequest;

import java.util.List;

public interface OrderViewService {
    public List<OrderViewResponse> getAllOrders();
    public OrderViewResponse getOrderById(Long id);
    public void addOrder(OrderRequest orderRequest, Long id);
}
