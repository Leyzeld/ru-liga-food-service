package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Integer id;
    private Float price;
    private Integer quantity;
    private String description;
    private String image;
}
