package ru.liga.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderViewResponse;
import ru.liga.model.OrderEntity;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final OrderItemMapper orderItemMapper;
    private final RestaurantMapper restaurantMapper;
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

    public OrderViewResponse toViewResponse (OrderEntity orderEntity) {
        OrderViewResponse orderViewResponse = new OrderViewResponse();
        orderViewResponse.setId(orderEntity.getId());
        orderViewResponse.setTimestamp(orderEntity.getTimestamp());
        orderViewResponse.setItems(orderItemMapper
                .toItemDtoList(orderEntity
                        .getOrderItemEntityList()));
        orderViewResponse.setRestaurantDto(restaurantMapper
                .mappEntityToDto(orderEntity
                        .getRestaurantEntity()));
        return orderViewResponse;
    }
}
