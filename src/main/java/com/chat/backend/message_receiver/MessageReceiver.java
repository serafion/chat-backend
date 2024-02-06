package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.Collection;
import java.util.List;

public interface MessageReceiver {

    String receiveMessage(List<String> message);
    Collection<MessageDto> getAllMessages();
}