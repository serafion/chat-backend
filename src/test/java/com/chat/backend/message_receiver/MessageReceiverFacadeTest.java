package com.chat.backend.message_receiver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageReceiverFacadeTest {

    @Test
    public void messageIsSentWithSuccess(){
        //Given
        MessageReceiverFacade messageReceiverFacade= new MessageReceiverFacade();
        List<String> message = List.of("User1","User2","I'd like to drink coffee today","2024-04-24 19:00:00");

        //When
        String response = messageReceiverFacade.receiveMessage(message);

        //Then
        assertThat(response).isEqualTo("success");
    }

    @Test
    public void messageIsSentButFailed(){
        //Given
        MessageReceiverFacade messageReceiverFacade= new MessageReceiverFacade();
        List<String> message = List.of("User1","User2","I'd like to drink coffee today","wrong timestamp");

        //When
        String response = messageReceiverFacade.receiveMessage(message);

        //Then
        assertThat(response).isEqualTo("failed");
    }
}
