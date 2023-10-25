package ru.liga.service.api;

import ru.liga.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDto>  deliveries();
    DeliveryDto getCourierById(Integer id);
    String addCourier(DeliveryDto newCourie);
    String updateCourierStatusPartially(Integer id, String status);
    String deleteCourierById(Integer id);
}
