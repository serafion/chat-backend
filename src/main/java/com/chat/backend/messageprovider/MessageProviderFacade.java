package com.chat.backend.messageprovider;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MessageProviderFacade {

    private final MessageRepository messageRepository;

    public List<List<String>> updateMessages(String userId){
        List<List<String>> messages = messageRepository.getMessagesForUser(userId);
        messageRepository.removeProcessedMessages(messages);
        return messages;
    }
}
