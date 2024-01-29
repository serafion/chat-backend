package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.Arrays;
import java.util.Optional;

class MessageValidator {

    public MessageStatus validate(Optional<MessageDto> optionalMessageDto) {
        if (optionalMessageDto.isEmpty()) return MessageStatus.NOT_PARSED;
        MessageDto messageDto = optionalMessageDto.get();
        boolean isValid = Arrays.stream(BasicValidators.values())
                .map(BasicValidators::getValidator)
                .allMatch(validator -> validator.validateCondition(messageDto));
        return fetchMessageStatus(isValid);
    }

    private MessageStatus fetchMessageStatus(boolean isValid) {
        if (isValid) {
            return MessageStatus.PARSED;
        } else {
            return MessageStatus.NOT_PARSED;
        }
    }
}
