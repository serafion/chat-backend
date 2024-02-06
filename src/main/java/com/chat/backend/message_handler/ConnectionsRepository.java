package com.chat.backend.message_handler;

public interface ConnectionsRepository {

    void add(Connections connections);
    void addNewContact(String userId, String userIdToList);

    void removeUserFromContacts (String userId, String userIdToList);
    boolean isInContacts(String userIdFrom, String userIdTo);
}
