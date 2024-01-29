package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

interface MessageRepository {

    void addMessage(MessageDto messageDto);
    void removeMessage(MessageDto messageDto);
    MessageDto getMessages(String from, String to);
}
