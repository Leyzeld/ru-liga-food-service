package ru.liga.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.RestaurantMenuItem;
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
    public RestaurantMenuItem getMenuItemById(Long id) {
        RestaurantMenuItem restaurantMenuItem = restaurantMenuItemMapper.
                mappEntityToDto(restaurantMenuItemsRepository.
                        findById(id).
                        orElseThrow());
        return restaurantMenuItem;
    }

    @Override
    public void setMenuItem(RestaurantMenuItemEntity restaurantMenuItemEntity) {
        restaurantMenuItemEntity
                .setRestaurantEntity(restaurantRepository
                        .findById(restaurantMenuItemEntity
                                .getRestaurantEntity()
                                .getRestId())
                                .orElseThrow());

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
