package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantMenuItem {
    private Long restaurant_menu_item_id;
    private Long restaurant_id;
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
}
