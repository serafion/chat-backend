package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.ArrayList;
import java.util.List;

class MessageRepositoryStub implements MessageRepository{

    List<MessageDto> repository = new ArrayList<>();
    @Override
    public void addMessage(MessageDto messageDto) {
        repository.add(messageDto);
    }

    @Override
    public void removeMessage(MessageDto messageDto) {
       repository.remove(messageDto);
    }

    @Override
    public MessageDto getMessages(String from, String to) {
        return null;
    }
}
