package ru.liga.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourierDto {
    private Long id;
    private String phone;
    private Float coordinates;
    private String status;
}
