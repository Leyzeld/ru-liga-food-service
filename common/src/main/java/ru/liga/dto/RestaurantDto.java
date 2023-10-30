package ru.liga.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private Long restaurant_id;
    private String address;
    private String status;
}
