package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
    private Long id;
    private Restaurant restaurant;
    private Timestamp timestamp;
    private List<Item> items;

}
