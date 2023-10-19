package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.DeliveryDto;
import ru.liga.service.api.DeliveryService;

import java.util.List;


@Tag(name = "API для службы доставки")
@RestController
@RequiredArgsConstructor
@RequestMapping ("/courier")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @Operation(summary = "Показать всех курьеров")
    @GetMapping("/all_couriers")
    public List<DeliveryDto> deliveries() {
        return deliveryService.deliveries();
    }
    @Operation(summary = "Показать курьера по ID")
    @GetMapping("/one_courier/{id}")
    public DeliveryDto getCourierById(@PathVariable("id") Integer id) {
        return deliveryService.getCourierById(id);
    }

    @Operation(summary = "Добавить курьера")
    @PostMapping("/addCourier")
    public String addCourier(@RequestBody DeliveryDto newCourier) {
        return deliveryService.addCourier(newCourier);
    }
    @Operation(summary = "Изменить статус курьера")
    @PutMapping("/{id}/{status}")
    public String updateCourierStatusPartially(@PathVariable("id") Integer id,
                                               @PathVariable("status") String status) {
        return deliveryService.updateCourierStatusPartially(id, status);
    }

    @Operation(summary = "Удалить курьера по ID")
    @DeleteMapping("/delete/{id}")
    public String deleteCourierById(@PathVariable(value = "id", required = true) Integer id) {
        return deliveryService.deleteCourierById(id);
    }

}
