package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO для пунктов меню")
public class MenuItems {
    @Schema(description = "Кол-во пунктов")
    private Long quantity;
    @Schema(description = "Товар")
    private Long restaurantMenuItemId;
}
