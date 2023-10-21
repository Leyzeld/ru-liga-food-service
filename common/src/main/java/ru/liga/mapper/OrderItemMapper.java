package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.OrderItem;
import ru.liga.model.OrderItemEntity;

@Component
public class OrderItemMapper {
    public OrderItem mappEntityToDto (OrderItemEntity entity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(entity.getId());
        orderItem.setOrder_id(entity.getOrderId().getId());
        orderItem.setRestaurant_menu_item_id(entity.getRestaurantMenuItemEntity().getRestMenuItemId());
        orderItem.setPrice(entity.getPrice());
        orderItem.setQuantity(entity.getQuantity());
        return orderItem;
    }
}
