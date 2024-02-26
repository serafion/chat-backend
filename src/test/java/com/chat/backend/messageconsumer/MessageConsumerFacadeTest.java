package com.chat.backend.messageconsumer;

import com.chat.backend.loginservice.LoginService;
import com.chat.backend.messageconsumer.dto.MessageDto;
import com.chat.backend.messageconsumer.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageConsumerFacadeTest {

    private final MessageRepository repository = new MessageRepositoryStub();


    @Test
    public void messageIsSentWithSuccess(){
        //Given
        UUID senderUUID = UUID.randomUUID();
        UUID receiverUUID = UUID.randomUUID();
        UserDto sender = new UserDto("John",senderUUID);
        MessageDto messageDto = new MessageDto(receiverUUID,"hello", Timestamp.from(Instant.now()));
        LoginService loginService = new LoginServiceStub(senderUUID,receiverUUID);
        MessageConsumerFacade messageReceiverFacade= new MessageConsumerFacade(repository,loginService);

        //When
        String response = messageReceiverFacade.consumeMessage(sender,messageDto);

        //Then
        assertThat(response).isEqualTo("success");
    }

    @Test
    public void messageIsSentButFailed(){
        //Given
        UUID senderUUID = UUID.randomUUID();
        UUID receiverUUID = UUID.randomUUID();
        UserDto sender = new UserDto("John",senderUUID);
        MessageDto messageDto = new MessageDto(receiverUUID,"hello", Timestamp.from(Instant.now()));
        LoginService loginService = new LoginServiceStub(receiverUUID,receiverUUID);
        MessageConsumerFacade messageReceiverFacade= new MessageConsumerFacade(repository,loginService);

        //When
        String response = messageReceiverFacade.consumeMessage(sender,messageDto);

        //Then
        assertThat(response).isEqualTo("failed");
    }
}
