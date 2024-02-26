package com.chat.backend.messageconsumer.dto;

import java.util.UUID;

public record UserDto(String userName, UUID userUuid) {
}
