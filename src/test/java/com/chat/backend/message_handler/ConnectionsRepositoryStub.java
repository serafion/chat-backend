package com.chat.backend.message_handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionsRepositoryStub implements ConnectionsRepository{

    Map<String, List<String>> map = new HashMap<>();
    @Override
    public void add(Connections connections) {
        map.put(connections.id(), connections.contacts());
    }

    @Override
    public void addNewContact(String userId, String userIdToList) {
        List<String> contacts = map.get(userId);
        contacts.add(userIdToList);
        map.put(userId,contacts);
    }

    @Override
    public void removeUserFromContacts(String userId, String userIdToList) {
        List<String> contacts = map.get(userId);
        contacts.remove(userIdToList);
        map.put(userId,contacts);
    }

    @Override
    public boolean isInContacts(String userIdFrom, String userIdTo) {
        return map.get(userIdFrom).contains(userIdTo);
    }
}
