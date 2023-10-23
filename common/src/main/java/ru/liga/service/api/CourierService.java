package ru.liga.service.api;

import ru.liga.dto.Courier;

import java.util.List;

public interface CourierService {
    public List<Courier> deliveries();
    public Courier getCourierById(Long id);
    public String addCourier(Courier newCourier);
    public String updateCourierStatusPartially(Long id, String status);
    public String deleteCourierById(Long id);
}
