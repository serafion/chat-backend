package com.chat.backend.message_receiver;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum MessageStatus {
    PARSED("success"),
    NOT_PARSED("failed");

    private final String status;
}
