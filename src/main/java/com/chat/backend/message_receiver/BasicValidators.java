package com.chat.backend.message_receiver;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum BasicValidators {

    MESSAGE_LENGTH_OK(messageDto -> messageDto.message().length() < 255),
    USER_FROM_NOT_NULL(messageDto -> messageDto.fromUser() != null),
    USER_TO_NOT_NULL(messageDto -> messageDto.toUser() != null),
    TIMESTAMP_NOT_NULL(messageDto -> messageDto.timestamp() != null);

    private final Validator validator;
}
