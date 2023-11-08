package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.RestaurantDto;
import ru.liga.model.RestaurantEntity;

@Component
public class RestaurantMapper {
    public RestaurantDto mappEntityToDto(RestaurantEntity restaurantEntity) {
        RestaurantDto restaurantDto = new RestaurantDto();
        if (restaurantEntity == null) {
            return restaurantDto;
        }
        restaurantDto.setRestaurant_id(restaurantEntity.getRestId());
        restaurantDto.setAddress(restaurantEntity.getAddress());
        restaurantDto.setStatus(restaurantEntity.getStatus().toString());
        return restaurantDto;
    }
}
