package ru.liga.service.api;

import ru.liga.dto.OrderMessage;
import ru.liga.dto.OrderViewResponse;
import ru.liga.dto.OrderRequest;

import java.util.List;
import java.util.UUID;

public interface OrderViewService {
    public List<OrderViewResponse> getAllOrders();
    public OrderViewResponse getOrderById(UUID id);
    public void addOrder(OrderRequest orderRequest, Long id);
    public OrderMessage updateOrderStatusById(OrderMessage orderMessage);
}
