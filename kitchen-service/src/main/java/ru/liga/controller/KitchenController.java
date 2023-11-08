package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.liga.service.api.KitchenService;

import java.util.UUID;

@Tag(name = "API для службы ресторана",
     description = "В данном REST контроллере описаны методы взаимодействия с заказом в ресторане")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/kitchen")
public class KitchenController {
    private final KitchenService kitchenService;
    @PostMapping("/acceptOrder")
    @Operation(
            summary = "Принять заказ",
            description = "Метод, в который передается id заказа если ресторан согласился принять заказ")
    public void acceptOrder(@PathVariable UUID id) {
        log.info("Получен POST запрос для принятия заказа id = {}", id);
        kitchenService.acceptOrder(id);
    }

    @PostMapping("/declineOrder")
    @Operation(
            summary = "Отклонить заказ",
            description = "Метод, в который передается id заказа если ресторан решил отклонить заказ")
    public void declineOrder(@PathVariable UUID id) {
        log.info("Получен POST запрос для отклонения заказа id = {}", id);
        kitchenService.declineOrder(id);
    }

    @PostMapping("/finishOrder")
    @Operation(
            summary = "Завершить заказ",
            description = "Метод, в который передается id заказа если ресторан приготовил заказ и ожидает курьера")
    public void finishOrder(@PathVariable UUID id) {
        log.info("Получен POST запрос для завершения приготовления заказа id = {}", id);
        kitchenService.readyOrder(id);
    }
}
