package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.OrderItem;
import ru.liga.model.OrderItemEntity;
import ru.liga.service.api.OrderItemService;

@Tag(name = "Api для работы с товаром в заказе")
@RestController
@RequestMapping("/order_item")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Operation(summary = "Получить товаром в заказе по ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getMenuItemById(@PathVariable("id") Long id) {
        return ResponseEntity.ok( orderItemService.getOrderItemById(id));
    }
    @Operation(summary = "Добавить товар")
    @PostMapping("/add")
    public void addMenuItem(@RequestBody OrderItemEntity orderItemEntity) {
        orderItemService.setOrderItem(orderItemEntity);
    }
    @Operation(summary = "Удалить товар в заказе по ID")
    @DeleteMapping("delete/{id}")
    public String  deleteMenuItemById(@PathVariable("id") Long id) {
        orderItemService.deleteOrderItemById(id);
        return "Позиция удалена";
    }
}
