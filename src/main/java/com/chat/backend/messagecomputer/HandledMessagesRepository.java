package com.chat.backend.messagecomputer;

import com.chat.backend.messageconsumer.dto.MessageDto;

import java.util.Collection;

public interface HandledMessagesRepository {

    void addAll(Collection<MessageDto> messageDtos);
    Collection<MessageDto> getAll();
    void deleteAll(Collection<MessageDto> messageDtos);
}
