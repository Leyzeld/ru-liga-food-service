package ru.liga.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {
    private String message;
    private String routingKey;
}
