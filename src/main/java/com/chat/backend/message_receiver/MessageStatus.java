package com.chat.backend.message_receiver;

import lombok.Getter;

@Getter
public enum MessageStatus {
    PARSED("success"),
    NOT_PARSED("failed");

    private final String status;

    MessageStatus(String status) {
        this.status = status;
    }
}
