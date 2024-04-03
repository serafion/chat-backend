package com.chat.backend.messageconsumer;

import com.chat.backend.loginservice.LoginService;
import com.chat.backend.loginservice.entity.User;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
public class LoginServiceStub implements LoginService {

    private UUID sender;
    private UUID receiver;


    @Override
    public boolean UserConnection(UUID sender, UUID receiver) {
        return sender.equals(this.sender)&&receiver.equals(this.receiver);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public List<User> onlineUsers() {
        return null;
    }

    @Override
    public void disconectUser(User user) {

    }
}
