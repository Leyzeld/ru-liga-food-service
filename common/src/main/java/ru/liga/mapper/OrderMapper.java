package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.OrderDto;
import ru.liga.model.OrderEntity;

@Component
public class OrderMapper {
    public OrderDto mappEntityToDto(OrderEntity orderEntity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderEntity.getId());
        orderDto.setCustomerId(orderEntity.getCustomerEntity().getId());
        orderDto.setRestaurantId(orderEntity.getRestaurantEntity().getRestId());
        orderDto.setStatus(orderEntity.getStatus());
        orderDto.setCourierId(orderEntity.getCourierEntity().getCourierId());
        orderDto.setTimestamp(orderEntity.getTimestamp());
        return orderDto;
    }
}
