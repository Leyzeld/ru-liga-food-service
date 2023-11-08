package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.liga.dto.OrderMessage;
import ru.liga.dto.OrderViewResponse;

import ru.liga.dto.OrderRequest;

import ru.liga.service.api.OrderViewService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Api для работы с заказом", description = "В данном REST контроллере описаны методы для работы с заказами")
@RestController
@Slf4j
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderViewService orderViewService;

    @Operation(summary = "Получить заказ по ID",
               description = "Метод который позволяет получить информацию о заказе по ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrderViewResponse> getOrderById(@PathVariable("id") UUID id) {
        log.info("Получен Get запрос для получения информации по заказу id = {}", id);
        return ResponseEntity.ok( orderViewService.getOrderById(id));
    }
    @Operation(summary = "Получить все заказы",
               description = "Метод который позволяет получить все заказ из БД")
    @GetMapping("/all")
    public ResponseEntity<List<OrderViewResponse>> getAllOrders() {
        log.info("Получен Get запрос для получения информации по всем заказам");
        return ResponseEntity.ok( orderViewService.getAllOrders());
    }
    @Operation(summary = "Добавить заказ",
            description = "Метод который позволяет создать новый заказ")
    @PostMapping("/add")
    public void addOrder(@RequestBody OrderRequest orderRequest,
                            @RequestParam ("Customer id") Long id) {
        log.info("Получен POST запрос для создания заказа");
        orderViewService.addOrder(orderRequest, id);
    }
    @Operation(summary = "Обновить информацию о заказе",
            description = "Метод который позволяет получить обновленную информацию о заказе")
    @PutMapping("/update")
    public ResponseEntity<OrderMessage> updateOrder(@Valid @RequestBody OrderMessage orderMessage) {
        log.info("Получен PUT запрос для обновления информации о заказе");
        return ResponseEntity.ok( orderViewService.updateOrderStatusById(orderMessage));
    }
}
