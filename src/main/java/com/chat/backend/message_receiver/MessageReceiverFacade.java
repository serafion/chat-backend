package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class MessageReceiverFacade implements MessageReceiver{

    private final MessageRepository messageRepository;
    private final MessageValidator validator;

    public String receiveMessage(List<String> message) {
        Optional<MessageDto> optionalMessageDto = parseMessageDto(message);
        MessageStatus status = validator.validate(optionalMessageDto);
        if(status.equals(MessageStatus.PARSED)) messageRepository.addMessage(optionalMessageDto.orElseThrow(RuntimeException::new));
        return status.getStatus();
    }

    @Override
    public Collection<MessageDto> getAllMessages() {
        Collection<MessageDto> messageDtos = messageRepository.getMessages();
        messageRepository.removeMessage(messageDtos);
        return messageDtos;
    }

    private static Optional<MessageDto> parseMessageDto(List<String> message) {
        Optional<MessageDto> messageDto;
        try{
            messageDto = Optional.of(MessageDtoMapper.toMessageDto(message));}
        catch (Exception ex) {
            messageDto = Optional.empty();
        }
        return messageDto;
    }
}
