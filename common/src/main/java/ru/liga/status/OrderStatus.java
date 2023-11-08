package ru.liga.status;

import lombok.Getter;

public enum OrderStatus {
    ORDER_CREATED("Заказ создан"),
    ORDER_ACCEPTED("Заказ принят"),
    ORDER_DECLINED("Заказ отменен"),
    ORDER_COOKING("Заказ готовится"),
    WAITING_FOR_COURIER("Ожидаем курьера"),
    DELIVERING("Заказ доставляется"),
    DELIVERED("Заказ доставлен");
    @Getter
    private String status;
    OrderStatus(String status) {
        this.status = status;
    }
}