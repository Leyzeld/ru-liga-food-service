package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.model.CourierEntity;
import ru.liga.repository.CourierRepository;

@Service
@RequiredArgsConstructor
public class FaingService {
    private static CourierRepository courierRepository;
    public static CourierEntity getCaseById(Long id) {
        return buildCase(id);
    }

    private static CourierEntity buildCase(Long id) {
        CourierEntity courier = courierRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException(String
                        .format("CourierEntity с id = %s не найден!", id)));
        courierRepository.updateStatusById(id, "работает");
        return courier;
    }
}
