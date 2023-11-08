package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.RestaurantMenuItemDto;
import ru.liga.mapper.RestaurantMenuItemMapper;
import ru.liga.model.RestaurantMenuItemEntity;
import ru.liga.repository.RestaurantMenuItemsRepository;
import ru.liga.repository.RestaurantRepository;
import ru.liga.service.api.RestaurantMenuItemsService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class RestaurantMenuItemsImpl implements RestaurantMenuItemsService {
    private final RestaurantMenuItemsRepository restaurantMenuItemsRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMenuItemMapper restaurantMenuItemMapper;
    @Override
    public RestaurantMenuItemDto getMenuItemById(Long id) {
        RestaurantMenuItemDto restaurantMenuItemDto = restaurantMenuItemMapper.
                mappEntityToDto(restaurantMenuItemsRepository.
                        findById(id).
                        orElseThrow(()->new RuntimeException(String.format("RestaurantMenuItemDto с id = %s не найден!", id))));
        return restaurantMenuItemDto;
    }

    @Override
    public void setMenuItem(RestaurantMenuItemEntity restaurantMenuItemEntity) {
        restaurantMenuItemEntity
                .setRestaurantEntity(restaurantRepository
                        .findById(restaurantMenuItemEntity
                                .getRestaurantEntity()
                                .getRestId())
                                .orElseThrow(()->new RuntimeException(String.format("Restaurant не найден!"))));

        restaurantMenuItemsRepository.save(restaurantMenuItemEntity);
    }

    @Override
    public void setNewPriceById(Long id, BigDecimal price) {
        restaurantMenuItemsRepository.updatePrice(id,price);
    }

    @Override
    public void deleteMenuItemById(Long id) {
        restaurantMenuItemsRepository.deleteById(id);
    }
}
