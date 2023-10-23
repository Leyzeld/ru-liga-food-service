package ru.liga.dto;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier {
    private Long id;
    private String phone;
    private Float coordinates;
    private String status;
}
