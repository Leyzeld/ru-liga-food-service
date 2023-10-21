package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.Order;
import ru.liga.model.OrderEntity;

@Component
public class OrderMapper {
    public Order mappEntityToDto(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setCustomerId(orderEntity.getCustomerEntity().getId());
        order.setRestaurantId(orderEntity.getRestaurantEntity().getRestId());
        order.setStatus(orderEntity.getStatus());
        order.setCourierId(orderEntity.getCourierEntity().getId());
        order.setTimestamp(orderEntity.getTimestamp());
        return order;
    }
}
