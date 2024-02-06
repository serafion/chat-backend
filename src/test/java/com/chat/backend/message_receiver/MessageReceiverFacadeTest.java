package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageReceiverFacadeTest {

    private final MessageRepository repository = new MessageRepositoryStub();
    private final MessageValidator validator = new MessageValidator();

    @Test
    public void messageIsSentWithSuccess(){
        //Given
        MessageReceiverFacade messageReceiverFacade= new MessageReceiverFacade(repository,validator);
        List<String> message = List.of("User1","User2","I'd like to drink coffee today","2024-04-24 19:00:00");

        //When
        String response = messageReceiverFacade.receiveMessage(message);

        //Then
        assertThat(response).isEqualTo("success");
    }

    @Test
    public void messageIsSentButFailed(){
        //Given
        MessageReceiverFacade messageReceiverFacade= new MessageReceiverFacade(repository,validator);
        List<String> message = List.of("User1","User2","I'd like to drink coffee today","wrong timestamp");

        //When
        String response = messageReceiverFacade.receiveMessage(message);

        //Then
        assertThat(response).isEqualTo("failed");
    }

    @Test
    public void messageSaveOneMessage(){
        //Given
        MessageReceiverFacade messageReceiverFacade= new MessageReceiverFacade(repository,validator);
        List<String> message = List.of("User1","User2","I'd like to drink coffee today","2024-04-24 19:00:00");
        messageReceiverFacade.receiveMessage(message);

        //When
        Collection<MessageDto> response = messageReceiverFacade.getAllMessages();

        //Then
        assertThat(response.size()).isEqualTo(1);
    }
}
