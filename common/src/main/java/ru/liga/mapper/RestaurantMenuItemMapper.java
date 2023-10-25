package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.RestaurantMenuItem;
import ru.liga.model.RestaurantEntity;
import ru.liga.model.RestaurantMenuItemEntity;

@Component
public class RestaurantMenuItemMapper {
    public RestaurantMenuItem mappEntityToDto (RestaurantMenuItemEntity entity) {
        RestaurantMenuItem restaurantMenuItem = new RestaurantMenuItem();
        restaurantMenuItem.setRestaurant_menu_item_id(entity.getRestMenuItemId());
        restaurantMenuItem.setRestaurant_id(entity.getRestaurantEntity().getRestId());
        restaurantMenuItem.setName(entity.getName());
        restaurantMenuItem.setPrice(entity.getPrice());
        restaurantMenuItem.setDescription(entity.getDescription());
        restaurantMenuItem.setImage(entity.getImage());
        return restaurantMenuItem;
    }

    public RestaurantMenuItemEntity mappDtoToEntity (RestaurantMenuItem dto) {
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
