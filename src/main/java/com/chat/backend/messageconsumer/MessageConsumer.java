package com.chat.backend.messageconsumer;

import com.chat.backend.messageconsumer.dto.MessageDto;
import com.chat.backend.messageconsumer.dto.UserDto;

import java.util.Collection;

public interface MessageConsumer {

    String consumeMessage(UserDto userDto, MessageDto message);
    Collection<MessageDto> getAllMessages(UserDto userDto);
}