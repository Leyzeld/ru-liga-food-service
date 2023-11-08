package ru.liga.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private UUID id;
    private Long customerId;
    private Long restaurantId;
    private String status;
    private Long courierId;
    private Timestamp timestamp;
}
