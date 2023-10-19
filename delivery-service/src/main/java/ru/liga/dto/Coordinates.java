package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Координаты курьера")
@Data
@Accessors(chain = true)
public class Coordinates {
    @Schema(description = "Координата Х")
    private Integer СoorX;
    @Schema(description = "Координата Y")
    private Integer СoorY;
}
