package ru.liga.service.api;

import ru.liga.model.CourierEntity;

import java.util.UUID;

public interface KitchenService {
    /*CourierEntity testFeign();*/
    void acceptOrder (UUID id);
    void declineOrder (UUID id);
    void readyOrder (UUID id);
}
