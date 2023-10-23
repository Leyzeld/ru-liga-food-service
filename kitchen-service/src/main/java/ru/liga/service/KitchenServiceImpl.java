package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.feign.CoreFeign;
import ru.liga.service.api.KitchenService;

@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {

    private final CoreFeign feign;
    @Override
    public String testFeign() {
        feign.getData(1L);
        return "OK";
    }
}
