package ru.liga.orderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.liga.itemDto.Item;
import ru.liga.restaurantDto.Restaurant;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderDto {
    private Integer id;
    private Integer restaurantId;
    private String timestamp;
    private List<Item> items;

    public void addToList (Item item) {
        items.add(item);
    }

}
