package com.chat.backend.messageproducer;

import java.util.List;

interface MessageRepository {

    List<List<String>> getMessagesForUser(String userId);
    void removeProcessedMessages(List<List<String>> messages);

}
