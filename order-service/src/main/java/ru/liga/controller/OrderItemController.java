package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.OrderItemDto;
import ru.liga.model.OrderItemEntity;
import ru.liga.service.api.OrderItemService;

@Tag(name = "Api для работы с товаром в заказе")
@RestController
@RequestMapping("/order_item")
@RequiredArgsConstructor
@Slf4j
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Operation(summary = "Получить товаром в заказе по ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getMenuItemById(@PathVariable("id") Long id) {
        log.info("Получение товара в заказе по ID: {}", id);
        return ResponseEntity.ok(orderItemService.getOrderItemById(id));
    }
    @Operation(summary = "Добавить товар")
    @PostMapping("/add")
    public void addMenuItem(@RequestBody OrderItemEntity orderItemEntity) {
        log.info("Добавление товара: {}", orderItemEntity);
        orderItemService.setOrderItem(orderItemEntity);
    }
    @Operation(summary = "Удалить товар в заказе по ID")
    @DeleteMapping("delete/{id}")
    public String  deleteMenuItemById(@PathVariable("id") Long id) {
        log.info("Удаление товара в заказе по ID: {}", id);
        orderItemService.deleteOrderItemById(id);
        return "Позиция удалена";
    }
}
