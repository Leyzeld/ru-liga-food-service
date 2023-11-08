package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.model.OrderEntity;
import ru.liga.service.api.DeliveryService;
import ru.liga.service.api.OrderService;
import ru.liga.status.OrderStatus;

import java.util.List;
import java.util.UUID;


@Tag(name = "API для службы доставки",
        description = "В данном REST контроллере описаны методы для работы курьеров с готовыми заказами")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/courier")
public class DeliveryController {
    private final OrderService orderService;
    private final DeliveryService deliveryService;
    @Operation(summary = "поиск доступных заказов",
            description = "Метод который позволяет получить все заказы со статусом ожидают курьера")
    @GetMapping
    public ResponseEntity<List<OrderEntity>> findAvailableDeliveries() {
        log.info("Поулчен GET запрос для поиска доступных заказов");
        return ResponseEntity.ok(orderService.getOrderByStatus(OrderStatus.WAITING_FOR_COURIER.getStatus()));
    }
    @Operation(summary = "забрать заказ",
            description = "Метод который позволяет курьеру забрать заказ для доставки и так же обновляет статус заказа"+
            " и так же меняет статус заказа на доставляется")
    @PostMapping("/take/{orderId}")
    public void takeOrder(@RequestParam ("Courier id") Long courierId,
                          @RequestParam ("Order id") UUID orderId) {
        log.info("Получен POST запрос для получения заказа id = {} курьером", orderId);
        orderService.setCourier(courierId, orderId);
    }
    @Operation(summary = "отдать заказ",
            description = "Метод который позволяет курьеру отдать заказ клиенту и так же меняет его статус")
    @PostMapping("/complete/{orderId}")
    public void completeOrder(@PathVariable UUID orderId) {
        log.info("Получен POST запрос для получения заказа id = {} клиентом", orderId);
        deliveryService.completeOrder(orderId);
    }

}
