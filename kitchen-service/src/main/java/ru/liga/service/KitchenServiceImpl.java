package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.feign.DeliveryFeignClient;
import ru.liga.model.CourierEntity;
import ru.liga.service.api.KitchenService;

@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {

    private final DeliveryFeignClient feign;
    @Override
    public CourierEntity testFeign() {
        return feign.getData(1L);
    }
}
