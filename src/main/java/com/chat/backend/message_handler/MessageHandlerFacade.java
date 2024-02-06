package com.chat.backend.message_handler;

import com.chat.backend.message_receiver.dto.MessageDto;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class MessageHandlerFacade implements MessageHandler {
    private final HandledMessagesRepository repository;
    private final ConnectionsChecker connectionsChecker;

    public List<MessageDto> getMessages() {

        Collection<MessageDto> handledMessageDtos = repository.getAll();
        repository.deleteAll(handledMessageDtos);

        return handledMessageDtos.stream().toList();
    }

    @Override
    public void processMessages(Collection<MessageDto> messageDtos) {
        Collection<MessageDto> correctMessages = messageDtos.stream()
                                                            .filter(messageDto -> connectionsChecker.checkIfUserCanReceiveMessage(messageDto.fromUser(), messageDto.toUser()))
                                                            .toList();

        repository.addAll(correctMessages);
    }
}
