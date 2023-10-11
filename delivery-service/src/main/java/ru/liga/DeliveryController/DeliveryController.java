package ru.liga.DeliveryController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.liga.Dto.DeliveryDto;

import java.util.ArrayList;
import java.util.List;

//http://localhost:8080/delivery/swagger-ui/index.html?continue#/
@Tag(name = "API для службы доставки")
@RestController
@RequestMapping ("/order")
public class DeliveryController {
    private List<DeliveryDto> deliveryDtoList = new ArrayList<>();
    DeliveryDto emptyCurier = new DeliveryDto();

    @Operation(summary = "Показать всех курьеров")
    @GetMapping("/curier")
    public List<DeliveryDto> deliveris() {
        return deliveryDtoList;
    }
    @Operation(summary = "Показать курьера по ID")
    @GetMapping("/curier/{id}")
    public DeliveryDto getCurierById(@PathVariable("id") Integer id) {
        if (deliveryDtoList.isEmpty()) {

            return emptyCurier;
        } else {
            return findById(id);
        }
    }

    @Operation(summary = "Добавить курьера")
    @PostMapping("/addCurier")
    public String update(@RequestParam Integer id,
                         @RequestParam String phone_number,
                         @RequestParam String status,
                         @RequestParam Short coordinates) {

        if (id.equals(findById(id).getId())) {
            return "Курьер уже существует";
        }

        DeliveryDto newCurier = new DeliveryDto();
        newCurier.setCoordinates(coordinates).
                setStatus(status).
                setPhone_number(phone_number).
                setId(id);
        deliveryDtoList.add(newCurier);
        return "Курьер добавлен";
    }
    @Operation(summary = "Изменить статус курьера")
    @PutMapping("/{id}/{status}")
    public String updateDeliveryPartially(@PathVariable("id") Integer id,
                                          @PathVariable("status") String status) {

        if (id.equals(findById(id).getId())) {
            deliveryDtoList.get(deliveryDtoList.indexOf(findById(id))).setStatus(status);
            return "Статус курьера изменен";
        }
        return "Курьер не найден";
    }

    @Operation(summary = "Удалить курьера по ID")
    @DeleteMapping("/delete/{id}")
    public String deleteCurierById(@PathVariable(value = "id", required = true) Integer id) {
        deliveryDtoList.remove(findById(id));
        return "Курьер с ID=" + id + "удален";
    }

    public DeliveryDto findById(Integer id) {
        return deliveryDtoList.stream().
                filter(_ddl -> id.equals(_ddl.getId())).
                findFirst().orElse(emptyCurier);
    }
}
