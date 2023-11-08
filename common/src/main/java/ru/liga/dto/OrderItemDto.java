package ru.liga.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Long id;
    private UUID order_id;
    private Long restaurant_menu_item_id;
    private BigDecimal price;
    private Long quantity;
}
