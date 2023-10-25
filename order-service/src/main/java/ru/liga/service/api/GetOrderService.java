package ru.liga.service.api;

import ru.liga.dto.GetOrderResponse;

import java.util.List;
import java.util.Optional;

public interface GetOrderService {
    public List<GetOrderResponse> getAllOrders();
    public GetOrderResponse getOrderById(Long id);
    public void addOrder(RestaurantService restaurantService);
}
