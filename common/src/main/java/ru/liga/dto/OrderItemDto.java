package ru.liga.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Long id;
    private Long order_id;
    private Long restaurant_menu_item_id;
    private BigDecimal price;
    private Long quantity;
}
