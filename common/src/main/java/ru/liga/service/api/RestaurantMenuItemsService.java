package ru.liga.service.api;

import ru.liga.dto.RestaurantMenuItemDto;
import ru.liga.model.RestaurantMenuItemEntity;

import java.math.BigDecimal;

public interface RestaurantMenuItemsService {
    public RestaurantMenuItemDto getMenuItemById(Long id);
    public void setMenuItem(RestaurantMenuItemEntity restaurantMenuItemEntity);
    public void setNewPriceById(Long id, BigDecimal price);
    public void deleteMenuItemById(Long id);
}
