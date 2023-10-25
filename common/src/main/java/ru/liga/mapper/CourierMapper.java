package ru.liga.mapper;

import org.springframework.stereotype.Component;
import ru.liga.dto.Courier;
import ru.liga.model.CourierEntity;

@Component
public class CourierMapper {
    public Courier mappEntityToDto (CourierEntity entity) {
        Courier courier = new Courier();
        courier.setId(entity.getCourierId());
        courier.setStatus(entity.getStatus());
        courier.setCoordinates(entity.getCoordinates());
        courier.setPhone(entity.getPhone());
        return courier;
    }

    public CourierEntity mappDtoToEntity (Courier dto) {
        CourierEntity courier = new CourierEntity();
        courier.setCourierId(dto.getId());
        courier.setStatus(dto.getStatus());
        courier.setCoordinates(dto.getCoordinates());
        courier.setPhone(dto.getPhone());
        return courier;
    }
}
