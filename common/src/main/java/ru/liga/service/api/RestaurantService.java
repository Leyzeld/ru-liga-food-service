package ru.liga.service.api;

import ru.liga.dto.Restaurant;
import java.util.Optional;

public interface RestaurantService {
    public Restaurant getRestaurantById(Long id);
}
