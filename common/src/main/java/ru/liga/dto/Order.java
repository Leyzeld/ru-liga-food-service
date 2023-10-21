package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Long customerId;
    private Long restaurantId;
    private String status;
    private Long courierId;
    private Timestamp timestamp;
}
