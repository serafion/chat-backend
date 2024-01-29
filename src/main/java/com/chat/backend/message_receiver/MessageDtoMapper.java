package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.sql.Timestamp;
import java.util.List;

class MessageDtoMapper {

    public static MessageDto toMessageDto(List<String> message){
        if(message.size()!=4) throw new RuntimeException("Wrong list length");
        return new MessageDto(message.get(0), message.get(1), message.get(2), Timestamp.valueOf(message.get(3)));
    }
}
