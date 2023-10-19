package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.OrderRequest;
import ru.liga.dto.OrderResponse;
import ru.liga.model.RestaurantMenuItemEntity;
import ru.liga.service.api.RestaurantMenuItemService;

@Tag(name = "API для позиций в меню")
@RestController
@RequestMapping("/restaurant_мenu_item")
@RequiredArgsConstructor
public class RestaurantMenuItemController {
    private final RestaurantMenuItemService restaurantMenuItemService;

    @Operation(summary = "Добавить пункт меню")
    @PostMapping("/add_restaurant_мenu_item")
    public void addNewRestaurantMenuItem(@RequestBody RestaurantMenuItemEntity restaurantMenuItemEntity) {
        restaurantMenuItemService.addRestaurantMenuItem(restaurantMenuItemEntity);
    }
    @Operation(summary = "Удалить пункт меню по ID")
    @DeleteMapping("/delete_restaurant_мenu_item/{id}")
    public void deleteRestaurantMenuItemById(@PathVariable(value = "id", required = true) Integer id) {
        restaurantMenuItemService.deleteRestaurantMenuItemById(id);
    }

}
