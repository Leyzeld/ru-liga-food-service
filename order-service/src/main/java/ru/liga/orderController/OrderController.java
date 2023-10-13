package ru.liga.orderController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.liga.orderDto.Dto;
import ru.liga.orderDto.OrderDto;
import ru.liga.orderDto.OrderRequest;
import ru.liga.orderDto.OrderResponse;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "API для заказов")
@RestController
@RequestMapping("/order")
public class OrderController {
    private Dto dto = new Dto();
    @Operation(summary = "Показать все заказы")
    @GetMapping("/orders")
    public Dto orders() {
        return dto;
    }
    @Operation(summary = "Показать заказ по ID")
    @GetMapping("/order/{id}")
    public OrderDto getOrderById(@PathVariable("id") Integer id) {
        if (dto.findById(id) == null) {
            return null;
        } else {
            return dto.findById(id);
        }
    }
    @Operation(summary = "Добавить заказ по ID")
    @PostMapping("/order")
    public OrderResponse addNewOrder(@RequestBody OrderRequest newOrder) {
        OrderDto tmp = new OrderDto();
        tmp.setId(1);
        tmp.setRestaurantId(newOrder.getRestaurantId());
        tmp.setItems(newOrder.getItemList());
        dto.addToList(tmp);
        return new OrderResponse();
    }

}
