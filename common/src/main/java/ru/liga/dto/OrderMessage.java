package ru.liga.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Статус и UUID заказа")
public class OrderMessage/* implements Serializable */{
    @NotNull
    @JsonProperty("order_id")
    private UUID orderId;
    @JsonProperty("order_status")
    private String orderStatus;
}
