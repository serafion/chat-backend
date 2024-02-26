package com.chat.backend.messageconsumer;

import com.chat.backend.loginservice.LoginService;
import com.chat.backend.messageconsumer.dto.MessageDto;
import com.chat.backend.messageconsumer.dto.UserDto;
import com.chat.backend.messageconsumer.entity.Message;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class MessageConsumerFacade implements MessageConsumer {

    private final MessageRepository messageRepository;
    private final LoginService loginService;

    public String consumeMessage(UserDto userDto, MessageDto messageDto) {
        boolean canGoThrough = loginService.UserConnection(userDto.userUuid(),messageDto.toUser());
        if(canGoThrough){
            Message message = new Message(userDto.userUuid(),messageDto.toUser(),messageDto.message(),messageDto.timestamp());
            messageRepository.addMessage(message);
            return MessageStatus.SENT.getStatus();
        } else {
            return MessageStatus.ERROR.getStatus();
        }
    }

    @Override
    public List<MessageDto> getAllMessages(UserDto userDto) {
        List<Message> messageDtos = messageRepository.getMessages(userDto.userUuid());
        messageRepository.removeMessageForUser(userDto.userUuid());
        return messageDtos.stream()
                .map(this::mapIntoMessageDto)
                .collect(Collectors.toList());
    }

    private MessageDto mapIntoMessageDto(Message message) {
        return new MessageDto(message.getReceiver(),message.getMessage(),message.getCreatedAt());
    }
}
