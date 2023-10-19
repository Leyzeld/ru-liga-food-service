package ru.liga.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.model.RestaurantMenuItemEntity;
import ru.liga.repository.api.RestaurantMenuItemRepository;
import ru.liga.service.api.RestaurantMenuItemService;

@Service
@Data
@RequiredArgsConstructor
public class RestaurantMenuItemServiceImpl implements RestaurantMenuItemService {

    private RestaurantMenuItemRepository restaurantMenuItemRepository;
    @Override
    public void addRestaurantMenuItem(RestaurantMenuItemEntity restaurantMenuItemEntity) {
        restaurantMenuItemRepository.save(restaurantMenuItemEntity);
    }

    @Override
    public void deleteRestaurantMenuItemById(Integer id) {
        restaurantMenuItemRepository.deleteById(id);
    }
}
