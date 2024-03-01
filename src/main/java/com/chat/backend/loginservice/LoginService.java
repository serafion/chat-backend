package com.chat.backend.loginservice;

import com.chat.backend.loginservice.entity.User;

import java.util.List;
import java.util.UUID;

public interface LoginService {

    boolean UserConnection (UUID sender, UUID receiver);
    void addUser(User user);
    List<User> onlineUsers();
    void disconectUser(User user);
}
