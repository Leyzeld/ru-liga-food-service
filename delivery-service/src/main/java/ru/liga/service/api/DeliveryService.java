package ru.liga.service.api;

import java.util.UUID;

public interface DeliveryService {
    void completeOrder (UUID orderId);
}
