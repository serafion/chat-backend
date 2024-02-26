package com.chat.backend.messageconsumer.dto;

import lombok.NonNull;

import java.sql.Timestamp;
import java.util.UUID;

public record MessageDto(@NonNull UUID toUser, @NonNull String message, Timestamp timestamp) {
}
