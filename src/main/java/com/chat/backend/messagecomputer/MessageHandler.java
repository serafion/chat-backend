package com.chat.backend.messagecomputer;

import com.chat.backend.messageconsumer.dto.MessageDto;

import java.util.Collection;
import java.util.List;

public interface MessageHandler {

    List<MessageDto> getMessages();
    void processMessages(Collection<MessageDto> messageDtos);
}
