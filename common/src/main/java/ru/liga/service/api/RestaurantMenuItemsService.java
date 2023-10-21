package ru.liga.service.api;

import ru.liga.dto.RestaurantMenuItem;
import ru.liga.model.RestaurantMenuItemEntity;

import java.math.BigDecimal;

public interface RestaurantMenuItemsService {
    public RestaurantMenuItem getMenuItemById(Long id);
    public void setMenuItem(RestaurantMenuItemEntity restaurantMenuItemEntity);
    public void setNewPriceById(Long id, BigDecimal price);
    public void deleteMenuItemById(Long id);
}
