package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.Item;
import ru.liga.dto.OrderItemDto;
import ru.liga.model.OrderItemEntity;

import java.util.ArrayList;
import java.util.List;

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
    public Item toItemDto (OrderItemEntity entity) {
        Item item = new Item();
        item.setPrice(entity.getPrice());
        item.setQuantity(entity.getQuantity());
        item.setDescription(entity.getRestaurantMenuItemEntity().getDescription());
        item.setImage(entity.getRestaurantMenuItemEntity().getImage());
        return item;
    }

    public List<Item> toItemDtoList (List<OrderItemEntity> entities) {
        List<Item> items = new ArrayList<>();
        for (OrderItemEntity entity:entities) {
            items.add(this.toItemDto(entity));
        }
        return items;
    }
}
