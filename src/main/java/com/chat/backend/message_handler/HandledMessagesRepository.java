package com.chat.backend.message_handler;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.Collection;

public interface HandledMessagesRepository {

    void addAll(Collection<MessageDto> messageDtos);
    Collection<MessageDto> getAll();
    void deleteAll(Collection<MessageDto> messageDtos);
}
