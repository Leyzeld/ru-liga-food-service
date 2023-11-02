package ru.liga.dtoDelivery;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Дто доставки")
@Data
@Accessors(chain = true)
public class DeliveryDto {
    @Schema(description = "Ид курьера")
    private Integer id;
    @Schema(description = "Номер телефона")
    private String phone_number;
    @Schema(description = "Статус")
    private String status;
    @Schema(description = "Координаты")
    private Coordinates coordinates;
}
