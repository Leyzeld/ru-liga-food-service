package ru.liga.Dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Schema(description = "Дто заказа")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDto {
    @Schema(description = "Ид курьера")
    private Integer id;
    @Schema(description = "Номер телефона")
    private String phone_number;
    @Schema(description = "Статус")
    private String status;
    @Schema(description = "Координаты")
    private Short coordinates;
}
