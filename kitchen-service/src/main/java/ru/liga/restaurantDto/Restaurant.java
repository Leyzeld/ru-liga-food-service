package ru.liga.restaurantDto;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Integer id;
    private String name;
    private String address;
    private Float distance;
}
