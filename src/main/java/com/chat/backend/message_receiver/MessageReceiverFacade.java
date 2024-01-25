package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;

import java.util.List;
import java.util.Optional;

public class MessageReceiverFacade {


    public String receiveMessage(List<String> message) {
        Optional<MessageDto> messageDto;
        try{
            messageDto = Optional.of(MessageDtoMapper.toMessageDto(message));}
        catch (Exception ex) {
            messageDto = Optional.empty();
        }
        if(messageDto.isPresent()){
            return MessageStatus.PARSED.getStatus();
        } else {
            return MessageStatus.NOT_PARSED.getStatus();
        }
    }
}
