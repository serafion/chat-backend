package com.chat.backend.message_handler;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.Collection;
import java.util.List;

public interface MessageHandler {

    List<MessageDto> getMessages();
    void processMessages(Collection<MessageDto> messageDtos);
}
