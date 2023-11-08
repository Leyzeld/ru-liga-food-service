package ru.liga.service.api;

import ru.liga.dto.RestaurantDto;

public interface RestaurantService {
    public RestaurantDto getRestaurantById(Long id);
}
