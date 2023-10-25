package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.Restaurant;
import ru.liga.model.RestaurantEntity;

@Component
public class RestaurantMapper {
    public Restaurant mappEntityToDto(RestaurantEntity restaurantEntity) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurant_id(restaurantEntity.getRestId());
        restaurant.setStatus(restaurantEntity.getStatus());
        restaurant.setAddress(restaurantEntity.getAddress());
        return restaurant;
    }
}
