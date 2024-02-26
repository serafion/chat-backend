package com.chat.backend.messagecomputer;

import com.chat.backend.messageconsumer.dto.MessageDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MessageHandlerFacadeTest {
    private final MessageRepositoryStub repositoryStub = new MessageRepositoryStub();
    private final ConnectionsRepositoryStub connectionsRepositoryStub = new ConnectionsRepositoryStub();
    private final ConnectionsChecker connectionsChecker = new ConnectionsChecker(connectionsRepositoryStub);

    private final Collection<MessageDto> dtos = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        MessageDto message1 = new MessageDto(UUID.randomUUID(),"I want a banana", Timestamp.valueOf("2024-04-24 19:00:00"));
        MessageDto message2 = new MessageDto(UUID.randomUUID(),"I want a cherry", Timestamp.valueOf("2024-04-24 19:00:00"));
        MessageDto message3 = new MessageDto(UUID.randomUUID(),"I want a apple", Timestamp.valueOf("2024-04-24 19:00:00"));
        MessageDto message4 = new MessageDto(UUID.randomUUID(),"I want a orange", Timestamp.valueOf("2024-04-24 19:00:00"));
        Connections connections = new Connections("Alek",List.of("Olek"));
        dtos.addAll(List.of(message1,message2,message3,message4));
        connectionsRepositoryStub.add(connections);
    }

    @Test
    void shouldSend4UpdatedMessages() {
        //Given
        repositoryStub.addAll(dtos);
        MessageHandlerFacade messageHandlerFacade = new MessageHandlerFacade(repositoryStub,connectionsChecker);

        //When
        List<MessageDto> handledMessageDtoList = messageHandlerFacade.getMessages();

        //Then
        assertThat(handledMessageDtoList.size()).isEqualTo(4);
    }

    @Test
    void shouldSend3UpdatedMessages() {
        //Given
        MessageHandlerFacade messageHandlerFacade = new MessageHandlerFacade(repositoryStub,connectionsChecker);

        //When
        messageHandlerFacade.processMessages(dtos);
        List<MessageDto> handledMessageDtoList = messageHandlerFacade.getMessages();

        //Then
        assertThat(handledMessageDtoList.size()).isEqualTo(3);
    }
}