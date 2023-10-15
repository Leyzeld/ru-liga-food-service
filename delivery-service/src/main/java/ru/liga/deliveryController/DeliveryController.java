package ru.liga.deliveryController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.dtoDelivery.DeliveryDto;
import ru.liga.service.DeliveryServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Tag(name = "API для службы доставки")
@RestController
@RequiredArgsConstructor
@RequestMapping ("/courier")
public class DeliveryController {
    private final DeliveryServiceImpl deliveryDto;

    @Operation(summary = "Показать всех курьеров")
    @GetMapping("/all_couriers")
    public List<DeliveryDto> deliveries() {
        return deliveryDto.deliveries();
    }
    @Operation(summary = "Показать курьера по ID")
    @GetMapping("/one_courier/{id}")
    public DeliveryDto getCourierById(@PathVariable("id") Integer id) {
        return deliveryDto.getCourierById(id);
    }

    @Operation(summary = "Добавить курьера")
    @PostMapping("/addCourier")
    public String addCourier(@RequestBody DeliveryDto newCourier) {
        return deliveryDto.addCourier(newCourier);
    }
    @Operation(summary = "Изменить статус курьера")
    @PutMapping("/{id}/{status}")
    public String updateCourierStatusPartially(@PathVariable("id") Integer id,
                                               @PathVariable("status") String status) {
        return deliveryDto.updateCourierStatusPartially(id, status);
    }

    @Operation(summary = "Удалить курьера по ID")
    @DeleteMapping("/delete/{id}")
    public String deleteCourierById(@PathVariable(value = "id", required = true) Integer id) {
        return deliveryDto.deleteCourierById(id);
    }

}
