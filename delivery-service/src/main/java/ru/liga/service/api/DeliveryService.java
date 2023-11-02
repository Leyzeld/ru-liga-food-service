package ru.liga.service.api;

import ru.liga.dtoDelivery.DeliveryDto;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<DeliveryDto>  deliveries();
    DeliveryDto getCourierById(Integer id);
    String addCourier(DeliveryDto newCourie);
    String updateCourierStatusPartially(Integer id, String status);
    String deleteCourierById(Integer id);
}
