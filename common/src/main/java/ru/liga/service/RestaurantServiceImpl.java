package ru.liga.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.Restaurant;
import ru.liga.mapper.RestaurantMapper;
import ru.liga.model.RestaurantEntity;
import ru.liga.repository.RestaurantRepository;
import ru.liga.service.api.RestaurantService;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Override
    public Restaurant getRestaurantById(Long id) {
        Restaurant restaurant = restaurantMapper.
                mappEntityToDto(restaurantRepository.
                        findById(id).
                        orElseThrow());
        return restaurant;
    }
}
