package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

interface Validator {

    boolean validateCondition(MessageDto messageDto);
}
