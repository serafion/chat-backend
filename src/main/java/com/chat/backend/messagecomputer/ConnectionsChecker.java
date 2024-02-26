package com.chat.backend.messagecomputer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConnectionsChecker {

    private ConnectionsRepository connectionsRepository;

    public boolean checkIfUserCanReceiveMessage(String userIdFrom, String userIdTo){
        return connectionsRepository.isInContacts(userIdFrom,userIdTo);
    }
}
