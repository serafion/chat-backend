package com.chat.backend.messageconsumer;

import com.chat.backend.loginservice.LoginService;
import lombok.AllArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
public class LoginServiceStub implements LoginService {

    private final UUID sender;
    private final UUID receiver;


    @Override
    public boolean UserConnection(UUID sender, UUID receiver) {
        return sender.equals(this.sender)&&receiver.equals(this.receiver);
    }
}
