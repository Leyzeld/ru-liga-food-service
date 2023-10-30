package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.liga.dto.OrderViewResponse;

import ru.liga.dto.OrderRequest;

import ru.liga.service.api.OrderViewService;

import java.util.List;

@Tag(name = "Api для работы с заказом")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderViewService orderViewService;

    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrderViewResponse> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok( orderViewService.getOrderById(id));
    }
    @Operation(summary = "Получить все заказы")
    @GetMapping("/all")
    public ResponseEntity<List<OrderViewResponse>> getAllOrders() {
        return ResponseEntity.ok( orderViewService.getAllOrders());
    }
    @Operation(summary = "Добавить заказ")
    @PostMapping("/add")
    public void addMenuItem(@RequestBody OrderRequest orderRequest,
                            @RequestParam ("Customer id") Long id) {
        orderViewService.addOrder(orderRequest, id);
    }

}
