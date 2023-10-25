package ru.liga.dto;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
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
