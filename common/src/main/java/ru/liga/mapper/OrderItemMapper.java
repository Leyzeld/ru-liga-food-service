package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.OrderItemDto;
import ru.liga.model.OrderItemEntity;

@Component
public class OrderItemMapper {
    public OrderItemDto mappEntityToDto (OrderItemEntity entity) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(entity.getId());
        orderItemDto.setOrder_id(entity.getOrderId().getId());
        orderItemDto.setRestaurant_menu_item_id(entity.getRestaurantMenuItemEntity().getRestMenuItemId());
        orderItemDto.setPrice(entity.getPrice());
        orderItemDto.setQuantity(entity.getQuantity());
        return orderItemDto;
    }
}
