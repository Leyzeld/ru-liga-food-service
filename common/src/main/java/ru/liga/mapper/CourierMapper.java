package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.CourierDto;
import ru.liga.model.CourierEntity;

@Component
public class CourierMapper {
    public CourierDto mappEntityToDto (CourierEntity entity) {
        CourierDto courierDto = new CourierDto();
        courierDto.setId(entity.getCourierId());
        courierDto.setStatus(entity.getStatus());
        courierDto.setCoordinates(entity.getCoordinates());
        courierDto.setPhone(entity.getPhone());
        return courierDto;
    }

    public CourierEntity mappDtoToEntity (CourierDto dto) {
        CourierEntity courier = new CourierEntity();
        courier.setCourierId(dto.getId());
        courier.setStatus(dto.getStatus());
        courier.setCoordinates(dto.getCoordinates());
        courier.setPhone(dto.getPhone());
        return courier;
    }
}
