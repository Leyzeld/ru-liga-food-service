package ru.liga.service.api;

import ru.liga.model.RestaurantMenuItemEntity;

public interface RestaurantMenuItemService {
    void addRestaurantMenuItem(RestaurantMenuItemEntity restaurantMenuItemEntity);
    void deleteRestaurantMenuItemById(Integer id);
}
