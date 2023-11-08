package ru.liga.status;

import lombok.Getter;

public enum CourierStatus {
    WORKING("Работает"),
    RESTING("Не работает"),
    DELIVERING("Доставляет заказ");
    @Getter
    private String status;
    CourierStatus(String status) {
        this.status = status;
    }
}
