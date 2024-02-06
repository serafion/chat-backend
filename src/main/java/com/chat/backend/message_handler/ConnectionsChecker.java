package com.chat.backend.message_handler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConnectionsChecker {

    private ConnectionsRepository connectionsRepository;

    public boolean checkIfUserCanReceiveMessage(String userIdFrom, String userIdTo){
        return connectionsRepository.isInContacts(userIdFrom,userIdTo);
    }
}
