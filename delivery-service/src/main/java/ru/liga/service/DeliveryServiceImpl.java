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

    @Override
    public List<DeliveryDto> deliveries() {
        return null;
    }

    @Override
    public DeliveryDto getCourierById(Integer id) {
        return null;
    }

    @Override
    public String addCourier(DeliveryDto newCourie) {
        return null;
    }

    @Override
    public String updateCourierStatusPartially(Integer id, String status) {
        return null;
    }

    @Override
    public String deleteCourierById(Integer id) {
        return null;
    }
}
