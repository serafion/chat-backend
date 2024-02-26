package com.chat.backend.messageconsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Message {
    private final UUID sender;
    private final UUID receiver;
    private final String message;
    private final Timestamp createdAt;
}
