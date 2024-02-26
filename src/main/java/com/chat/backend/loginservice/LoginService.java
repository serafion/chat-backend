package com.chat.backend.loginservice;

import java.util.UUID;

public interface LoginService {

    public boolean UserConnection (UUID sender, UUID receiver);
}
