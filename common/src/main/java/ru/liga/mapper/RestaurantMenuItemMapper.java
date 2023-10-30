package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.RestaurantMenuItemDto;
import ru.liga.model.RestaurantEntity;
import ru.liga.model.RestaurantMenuItemEntity;

@Component
public class RestaurantMenuItemMapper {
    public RestaurantMenuItemDto mappEntityToDto (RestaurantMenuItemEntity entity) {
        RestaurantMenuItemDto restaurantMenuItemDto = new RestaurantMenuItemDto();
        restaurantMenuItemDto.setRestaurant_menu_item_id(entity.getRestMenuItemId());
        restaurantMenuItemDto.setRestaurant_id(entity.getRestaurantEntity().getRestId());
        restaurantMenuItemDto.setName(entity.getName());
        restaurantMenuItemDto.setPrice(entity.getPrice());
        restaurantMenuItemDto.setDescription(entity.getDescription());
        restaurantMenuItemDto.setImage(entity.getImage());
        return restaurantMenuItemDto;
    }

    public RestaurantMenuItemEntity mappDtoToEntity (RestaurantMenuItemDto dto) {
        RestaurantMenuItemEntity restaurantMenuItemEntity = new RestaurantMenuItemEntity();
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setRestId(dto.getRestaurant_id());
        restaurantMenuItemEntity.setRestaurantEntity(restaurantEntity);
        restaurantMenuItemEntity.setRestMenuItemId(dto.getRestaurant_menu_item_id());
        restaurantMenuItemEntity.setName(dto.getName());
        restaurantMenuItemEntity.setPrice(dto.getPrice());
        restaurantMenuItemEntity.setDescription(dto.getDescription());
        restaurantMenuItemEntity.setImage(dto.getImage());
        return restaurantMenuItemEntity;
    }

}
