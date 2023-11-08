package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO для создания заказа")
public class OrderRequest {
    @Schema(description = "ID ресторана из которого будет доставлена еда")
    private Long restaurantId;
    @Schema(description = "Список пунктов меню")
    private List<MenuItems> menuItems;
}
