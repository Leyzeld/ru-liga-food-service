package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderViewResponse {
    private Long id;
    private RestaurantDto restaurantDto;
    private Timestamp timestamp;
    private List<Item> items;

}
