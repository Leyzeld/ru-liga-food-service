package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.liga.dto.GetOrderResponse;

import ru.liga.dto.OrderRequest;

import ru.liga.service.api.GetOrderService;

import java.util.List;

@Tag(name = "Api для работы с заказом")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final GetOrderService getOrderService;

    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/{id}")
    public ResponseEntity<GetOrderResponse> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok( getOrderService.getOrderById(id));
    }
    @Operation(summary = "Получить все заказы")
    @GetMapping("/all")
    public ResponseEntity<List<GetOrderResponse>> getAllOrders() {
        return ResponseEntity.ok( getOrderService.getAllOrders());
    }
    @Operation(summary = "Добавить заказ")
    @PostMapping("/add")
    public void addMenuItem(@RequestBody OrderRequest orderRequest,
                            @RequestParam ("Customer id") Long id) {
        getOrderService.addOrder(orderRequest, id);
    }

}
