package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.Collection;

interface MessageRepository {

    void addMessage(MessageDto messageDto);
    void removeMessage(Collection<MessageDto> messageDtos);
    Collection<MessageDto> getMessages();
}
