package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.model.OrderItemEntity;
import ru.liga.service.api.OrderItemService;

import java.util.List;


@Tag(name = "API для товара")
@RestController
@RequestMapping("/order_item")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Operation(summary = "Добавить пункт меню")
    @GetMapping("/get_order_item")
    public List<OrderItemEntity> getAllOrderItem() {
        return orderItemService.showAll();

    }

    @Operation(summary = "Добавить пункт меню")
    @PostMapping("/order_item")
    public void addNewOrderItem(@RequestBody OrderItemEntity orderItemEntity) {
        orderItemService.addOrderItem(orderItemEntity);
    }
    @Operation(summary = "Удалить пункт меню по ID")
    @DeleteMapping("/delete_order_item/{id}")
    public void deleteOrderItemById(@PathVariable(value = "id", required = true) Integer id) {
        orderItemService.deleteOrderItemById(id);
    }
}
