package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.CourierDto;
import ru.liga.model.CourierEntity;
import ru.liga.service.FaingService;
import ru.liga.service.api.CourierService;

import java.util.List;


@Tag(name = "API для службы доставки")
@RestController
@RequiredArgsConstructor
@RequestMapping ("/courier")

public class DeliveryController {
    private final CourierService courierService;
    private final FaingService faingService;

    @Operation(summary = "Показать всех курьеров")
    @GetMapping("/all_couriers")
    public List<CourierDto> deliveries() {
        return courierService.deliveries();
    }
    @Operation(summary = "Показать курьера по ID")
    @GetMapping("/one_courier/{id}")
    public CourierDto getCourierById(@PathVariable("id") Long id) {
        return courierService.getCourierById(id);
    }

    @Operation(summary = "Добавить курьера")
    @PostMapping("/addCourier")
    public String addCourier(@RequestBody CourierDto newCourierDto) {
        return courierService.addCourier(newCourierDto);
    }
    @Operation(summary = "Изменить статус курьера")
    @PutMapping("/{id}/{status}")
    public String updateCourierStatusPartially(@RequestParam(name = "id") Long id,
                                               @RequestParam(name = "status") String status) {
        return courierService.updateCourierStatusPartially(id, status);
    }

    @Operation(summary = "Удалить курьера по ID")
    @DeleteMapping("/delete/{id}")
    public String deleteCourierById(@PathVariable(value = "id", required = true) Long id) {
        return courierService.deleteCourierById(id);
    }

    @Operation(summary = "TestFeign")
    @GetMapping("/{caseId}")
    public CourierEntity getById(@RequestParam(name = "caseId") Long caseId) {
        return FaingService.getCaseById(caseId);
    }

}
