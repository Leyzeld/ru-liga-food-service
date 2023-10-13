package ru.liga.orderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.itemDto.Item;
import ru.liga.restaurantDto.Restaurant;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private Integer restaurantId;
    private OffsetDateTime timestamp;
    private List<Item> items;

}
