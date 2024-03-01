package com.chat.backend.loginservice;

import com.chat.backend.loginservice.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LoginServiceFacade implements LoginService{

    private final UserRepository repository;
    @Override
    public boolean UserConnection(UUID sender, UUID receiver) {
        return false;
    }

    @Override
    public void addUser(User user) {
        user.setStatus(OnlineStatus.Online);
        repository.save(user);
    }

    @Override
    public List<User> onlineUsers() {
        return repository.findAllByStatus();
    }

    @Override
    public void disconectUser(User user) {
        Optional<User> userOptional = repository.findById(user.getIdentifier());
        if(userOptional.isEmpty()){
            user.setStatus(OnlineStatus.Offline);
            repository.save(user);
        } else {
            User dbUser = userOptional.get();
            dbUser.setStatus(OnlineStatus.Offline);
            repository.save(dbUser);
        }
    }
}
