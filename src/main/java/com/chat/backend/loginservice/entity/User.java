package com.chat.backend.loginservice.entity;

import com.chat.backend.loginservice.OnlineStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
@Getter
@Setter
@AllArgsConstructor
public class User {
    private final String name;
    @Id
    private final UUID identifier;
    private OnlineStatus status;
    private final String email;
    private List<User> connections;
}
