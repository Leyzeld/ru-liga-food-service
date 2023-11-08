package ru.liga.service.api;

import ru.liga.dto.CourierDto;

import java.util.List;

public interface CourierService {
    public List<CourierDto> deliveries();
    public CourierDto getCourierById(Long id);
    public String addCourier(CourierDto newCourierDto);
    public String updateCourierStatusPartially(Long id, String status);
    public String deleteCourierById(Long id);
}
