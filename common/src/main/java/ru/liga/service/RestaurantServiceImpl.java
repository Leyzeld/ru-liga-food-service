package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.RestaurantDto;
import ru.liga.mapper.RestaurantMapper;
import ru.liga.repository.RestaurantRepository;
import ru.liga.service.api.RestaurantService;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        RestaurantDto restaurantDto = restaurantMapper.
                mappEntityToDto(restaurantRepository.
                        findById(id).
                        orElseThrow(()->new RuntimeException(String.format("RestaurantDto с id = %s не найден!", id))));
        return restaurantDto;
    }
}
