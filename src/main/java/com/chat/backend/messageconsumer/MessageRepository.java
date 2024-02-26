package com.chat.backend.messageconsumer;

import com.chat.backend.messageconsumer.entity.Message;

import java.util.List;
import java.util.UUID;

interface MessageRepository {

    void addMessage(Message messageDto);
    List<Message> getMessages(UUID userUUID);
    void removeMessageForUser(UUID uuid);
}
