package com.chat.backend.messageconsumer;

import com.chat.backend.messageconsumer.entity.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class MessageRepositoryStub implements MessageRepository{

    private final List<Message> repository = new ArrayList<>();

    @Override
    public void addMessage(Message message) {
        repository.add(message);

    }

    @Override
    public List<Message> getMessages(UUID userUUID) {
        return repository.stream()
                         .filter(s -> s.getReceiver().equals(userUUID))
                         .toList();
    }

    @Override
    public void removeMessageForUser(UUID uuid) {
        List<Message> messages = repository.stream()
                                           .filter(s -> s.getReceiver().equals(uuid))
                                           .toList();
        repository.removeAll(messages);
    }
}
