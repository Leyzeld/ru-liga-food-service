package ru.liga.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.feign.CoreFeign;
import ru.liga.service.api.KitchenService;

@Tag(name = "API для службы ресторана")
@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
public class KitchenController {
    private final KitchenService coreFeign;
    @GetMapping("/feign")
    public void test() {
        coreFeign.testFeign();
    }
}
