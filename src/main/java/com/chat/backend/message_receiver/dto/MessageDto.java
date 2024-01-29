package com.chat.backend.message_receiver.dto;

import java.sql.Timestamp;

public record MessageDto(String fromUser,String toUser,String message,Timestamp timestamp) {
}
