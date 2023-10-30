package ru.liga.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {
    private Long orderIdWithoutCourier;
    private String routingKey;
}
