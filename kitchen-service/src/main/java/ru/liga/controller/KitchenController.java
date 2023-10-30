package ru.liga.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.model.CourierEntity;
import ru.liga.service.api.KitchenService;
import ru.liga.service.api.OrderService;

@Tag(name = "API для службы ресторана")
@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
public class KitchenController {
    private final KitchenService kitchenService;
    private final OrderService orderService;
    @GetMapping("/feign")
    public CourierEntity test() {

        return kitchenService.testFeign();
    }
}
