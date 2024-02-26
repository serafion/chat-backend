package com.chat.backend.messagecomputer;

public interface ConnectionsRepository {

    void add(Connections connections);
    void addNewContact(String userId, String userIdToList);

    void removeUserFromContacts (String userId, String userIdToList);
    boolean isInContacts(String userIdFrom, String userIdTo);
}
