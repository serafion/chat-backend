package com.chat.backend.messageconsumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum MessageStatus {
    SENT("success"),
    ERROR("failed");

    private final String status;
}
