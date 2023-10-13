package ru.liga.deliveryController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.liga.dtoDelivery.Coordinates;
import ru.liga.dtoDelivery.DeliveryDto;

import java.util.ArrayList;
import java.util.List;

//http://localhost:8080/delivery/swagger-ui/index.html?continue#/
@Tag(name = "API для службы доставки")
@RestController
@RequestMapping ("/courier")
public class DeliveryController {
    private List<DeliveryDto> deliveryDtoList = new ArrayList<>();

    @Operation(summary = "Показать всех курьеров")
    @GetMapping("/all_couriers")
    public List<DeliveryDto> deliveris() {
        return deliveryDtoList;
    }
    @Operation(summary = "Показать курьера по ID")
    @GetMapping("/one_courier/{id}")
    public DeliveryDto getCourierById(@PathVariable("id") Integer id) {
        if (deliveryDtoList.isEmpty()) {
            return null;
        } else {
            return findById(id);
        }
    }

    @Operation(summary = "Добавить курьера")
    @PostMapping("/addCourier")
    public String update(@RequestBody DeliveryDto newCourier) {

        if (findById(newCourier.getId()) == null) {
            deliveryDtoList.add(newCourier);
            return "Курьер добавлен";
        } else {
            return "Курьер уже существует";
        }
    }
    @Operation(summary = "Изменить статус курьера")
    @PutMapping("/{id}/{status}")
    public String updateCourierStatusPartially(@PathVariable("id") Integer id,
                                               @PathVariable("status") String status) {
        if (findById(id) == null) {
            return "Курьер не найден";
        } else {
            deliveryDtoList.get(deliveryDtoList.indexOf(findById(id))).setStatus(status);
            return "Статус курьера изменен";
        }
    }

    @Operation(summary = "Удалить курьера по ID")
    @DeleteMapping("/delete/{id}")
    public String deleteCourierById(@PathVariable(value = "id", required = true) Integer id) {
        deliveryDtoList.remove(findById(id));
        return "Курьер с ID= " + id + " удален";
    }

    public DeliveryDto findById(Integer id) {
        return deliveryDtoList.stream().
                filter(_ddl -> id.equals(_ddl.getId())).
                findFirst().orElse(null);
    }
}
