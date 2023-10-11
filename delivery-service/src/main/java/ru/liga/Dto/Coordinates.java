package ru.liga.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Координаты курьера")
@Data
@Accessors(chain = true)
public class Coordinates {
    @Schema(description = "Координата Х")
    private Integer coor_X;
    @Schema(description = "Координата Y")
    private Integer coor_Y;
}
