package ru.liga.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liga.model.CourierEntity;

@FeignClient(name = "core-service", url = "http://localhost:8087/delivery/courier")
public interface DeliveryFeignClient {

    @GetMapping("/{caseId}")
    CourierEntity getData(@RequestParam("caseId") Long caseId);
}
