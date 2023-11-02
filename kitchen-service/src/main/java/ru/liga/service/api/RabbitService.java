package ru.liga.service.api;

import ru.liga.model.MessageEntity;

public interface RabbitService {
    void sendMsg(MessageEntity messageEntity);
}
