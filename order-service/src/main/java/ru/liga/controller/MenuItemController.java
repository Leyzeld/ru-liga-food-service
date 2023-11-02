package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.RestaurantMenuItemDto;
import ru.liga.model.RestaurantMenuItemEntity;
import ru.liga.service.api.RestaurantMenuItemsService;

import java.math.BigDecimal;

@Tag(name = "Api для работы с пунктами меню")
@RestController
@RequestMapping("/menu_item")
@RequiredArgsConstructor
public class MenuItemController {
    private final RestaurantMenuItemsService restaurantMenuItemsService;

    @Operation(summary = "Получить пункт меню по ID")
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantMenuItemDto>  getMenuItemById(@PathVariable("id") Long id) {
        return ResponseEntity.ok( restaurantMenuItemsService.getMenuItemById(id));
    }
    @Operation(summary = "Добавить пункт меню")
    @PostMapping("/add")
    public void addMenuItem(@RequestBody RestaurantMenuItemEntity restaurantMenuItem) {
        restaurantMenuItemsService.setMenuItem(restaurantMenuItem);
    }
    @Operation(summary = "Обновить цену пункта меню")
    @PutMapping("/update_price")
    public void updateMenuItem(@RequestParam(name = "id") Long id,
                               @RequestParam(name = "price") BigDecimal price) {
        restaurantMenuItemsService.setNewPriceById(id, price);
    }
    @Operation(summary = "Удалить пункт меню по ID")
    @DeleteMapping("delete/{id}")
    public String  deleteMenuItemById(@PathVariable("id") Long id) {
        restaurantMenuItemsService.deleteMenuItemById(id);
        return "Позиция удалена";
    }
}
