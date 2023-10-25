package ru.liga.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.liga.dto.GetOrderResponse;;
import ru.liga.dto.RestaurantMenuItem;
import ru.liga.model.OrderEntity;
import ru.liga.model.OrderItemEntity;
import ru.liga.model.RestaurantEntity;
import ru.liga.model.RestaurantMenuItemEntity;
import ru.liga.repository.OrderItemRepository;
import ru.liga.repository.OrderRepository;
import ru.liga.repository.RestaurantMenuItemsRepository;
import ru.liga.repository.RestaurantRepository;
import ru.liga.service.api.GetOrderService;
import ru.liga.service.api.RestaurantService;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class GetOrderServiceImpl implements GetOrderService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMenuItemsRepository restaurantMenuItemsRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<GetOrderResponse> getAllOrders() {
        List<GetOrderResponse> getOrderResponseList = new ArrayList<>();
        //
        return getOrderResponseList;
    }

    @Override
    public GetOrderResponse getOrderById(Long id) {
        GetOrderResponse getOrderResponse = new GetOrderResponse();
/*
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow();
        List<OrderItemEntity> orderItemEntityList = orderItemRepository.findOrderItemByOrderId(id);
*/

        //List<RestaurantMenuItemEntity> restaurantMenuItemEntityList = restaurantMenuItemsRepository.findAllById();
        return getOrderResponse;
    }

    @Override
    public void addOrder(RestaurantService restaurantService) {

    }

}
