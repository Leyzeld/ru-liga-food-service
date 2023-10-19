package ru.liga.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.liga.dto.DeliveryDto;
import ru.liga.service.api.DeliveryService;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class DeliveryServiceImpl implements DeliveryService {
    List<DeliveryDto> deliveryDtos = new ArrayList<>();
    @Override
    public List<DeliveryDto> deliveries() {
        return deliveryDtos;
    }

    @Override
    public DeliveryDto getCourierById(Integer id) {
        if (deliveryDtos.isEmpty()) {
            throw new RuntimeException("Курьер с данным ID не найден");
        } else {
            return findById(id);
        }
    }

    @Override
    public String addCourier(DeliveryDto newCourier) {
        if (findById(newCourier.getId()) == null) {
            deliveryDtos.add(newCourier);
            return "Курьер добавлен";
        } else {
            return "Курьер уже существует";
        }
    }

    @Override
    public String updateCourierStatusPartially(Integer id, String status) {
        if (findById(id) == null) {
            return "Курьер не найден";
        } else {
            deliveryDtos.get(deliveryDtos.indexOf(findById(id))).setStatus(status);
            return "Статус курьера изменен";
        }
    }

    @Override
    public String deleteCourierById(Integer id) {
        deliveryDtos.remove(findById(id));
        return "Курьер с ID= " + id + " удален";
    }
    public DeliveryDto findById(Integer id) {
        return deliveryDtos.stream().
                filter(_ddl -> id.equals(_ddl.getId())).
                findFirst().orElse(null);
    }
}
