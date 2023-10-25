package ru.liga.service;

import org.springframework.stereotype.Service;
import ru.liga.model.CourierEntity;

@Service
public class FaingService {
    public static CourierEntity getCaseById(Long id) {
        return buildCase();
    }

    private static CourierEntity buildCase() {
        CourierEntity courier = new CourierEntity();
        courier.setCourierId(1488L);
        courier.setPhone("phone");
        courier.setCoordinates(2.3f);
        courier.setStatus("waiting so long");
        return courier;
    }
}
