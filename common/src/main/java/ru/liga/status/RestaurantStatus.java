package ru.liga.status;

import lombok.Getter;

public enum RestaurantStatus {
    OPEN("Открыт"),
    CLOSED("Закрыт");
    @Getter
    private String status;
    RestaurantStatus(String status) {
        this.status = status;
    }
}
