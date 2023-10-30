package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.CourierDto;
import ru.liga.mapper.CourierMapper;
import ru.liga.model.CourierEntity;
import ru.liga.repository.CourierRepository;
import ru.liga.service.api.CourierService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;
    @Override
    public List<CourierDto> deliveries() {
        List<CourierDto> courierDtoList = courierMapper
                .mappListEntityToDto(courierRepository.findAll());
        return courierDtoList;
    }

    @Override
    public CourierDto getCourierById(Long id) {
        CourierDto courierDto = courierMapper
                .mappEntityToDto(courierRepository
                        .findById(id)
                        .orElseThrow());
        return courierDto;

    }

    @Override
    public String addCourier(CourierDto newCourierDto) {
        courierRepository.save(courierMapper.mappDtoToEntity(newCourierDto));
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
