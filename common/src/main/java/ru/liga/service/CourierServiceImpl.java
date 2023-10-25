package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.Courier;
import ru.liga.mapper.CourierMapper;
import ru.liga.model.CourierEntity;
import ru.liga.repository.CourierRepository;
import ru.liga.service.api.CourierService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;
    @Override
    public List<Courier> deliveries() {
        List<CourierEntity> all = courierRepository.findAll();
        List<Courier> courierList = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            courierList.add(courierMapper.mappEntityToDto(all.get(i)));
        }
        return courierList;
    }

    @Override
    public Courier getCourierById(Long id) {
        Courier courier = courierMapper
                .mappEntityToDto(courierRepository
                        .findById(id)
                        .orElseThrow());
        return courier;

    }

    @Override
    public String addCourier(Courier newCourier) {
        courierRepository.save(courierMapper.mappDtoToEntity(newCourier));
        return "курьер добавлен";
    }

    @Override
    public String updateCourierStatusPartially(Long id, String status) {
        courierRepository.updateStatusById(id,status);
        return "запрос отправлен";
    }

    @Override
    public String deleteCourierById(Long id) {
        courierRepository.deleteById(id);
        return "курьер уволен";
    }
}
