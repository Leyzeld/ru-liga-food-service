package ru.liga.orderController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.orderDto.Dto;
import ru.liga.orderDto.OrderDto;
import ru.liga.orderDto.OrderRequest;
import ru.liga.orderDto.OrderResponse;
import ru.liga.service.api.OrderService;

import java.util.Optional;


@Tag(name = "API для заказов")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "Показать все заказы")
    @GetMapping("/orders")
    public Dto orders() {
        return orderService.getAllDto();
    }
    @Operation(summary = "Показать заказ по ID")
    @GetMapping("/order/{id}")
    public Optional<OrderDto> getOrderById(@PathVariable("id") Integer id) {
        return orderService.getDtoById(id);
    }
    @Operation(summary = "Добавить заказ по ID")
    @PostMapping("/order")
    public OrderResponse addNewOrder(@RequestBody OrderRequest newOrder) {
        return orderService.makeOrder(newOrder);
    }

}
