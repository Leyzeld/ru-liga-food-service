package ru.liga.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantMenuItemDto {
    private Long restaurant_menu_item_id;
    private Long restaurant_id;
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
}
