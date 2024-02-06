package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

class MessageRepositoryStub implements MessageRepository{

    private final List<MessageDto> repository = new Vector<>();
    @Override
    public void addMessage(MessageDto messageDto) {
        repository.add(messageDto);
    }

    @Override
    public void removeMessage(Collection<MessageDto> messageDtos) {
       List<MessageDto> forRemoval = List.copyOf(messageDtos);
       forRemoval.forEach(repository::remove);
    }

    @Override
    public Collection<MessageDto> getMessages() {
        return List.copyOf(repository);
    }
}
