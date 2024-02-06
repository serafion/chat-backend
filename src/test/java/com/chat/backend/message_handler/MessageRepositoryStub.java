package com.chat.backend.message_handler;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.ArrayList;
import java.util.Collection;

public class MessageRepositoryStub implements HandledMessagesRepository{

    Collection<MessageDto> dtos = new ArrayList<>();
    @Override
    public void addAll(Collection<MessageDto> messageDtos) {
        dtos.addAll(messageDtos);
    }

    @Override
    public Collection<MessageDto> getAll() {
        return dtos.stream().toList();
    }

    @Override
    public void deleteAll(Collection<MessageDto> messageDtos) {
        dtos.clear();
    }
}
