package com.chat.backend.messageproducer;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MessageRepositoryStub implements MessageRepository{

    private final HashMap<String,List<List<String>>> messagesMap = new HashMap<>();

    public MessageRepositoryStub(String userId, List<List<String>> messages) {
        messagesMap.put(userId,messages);
    }


    @Override
    public List<List<String>> getMessagesForUser(String userId) {
        return messagesMap.get(userId);
    }

    @Override
    public void removeProcessedMessages(List<List<String>> messages) {
        Set<String> keys = messagesMap.keySet();
        for(String key : keys){
            if(messagesMap.get(key).equals(messages)){
                messagesMap.remove(key);
            }
        }
    }
}
