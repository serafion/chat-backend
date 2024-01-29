package com.chat.backend.message_receiver;

import com.chat.backend.message_receiver.dto.MessageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageValidatorTest {

    @Test
    public void shouldValidateCorrectMessage(){
        //Given
        MessageValidator messageValidator = new MessageValidator();
        Optional<MessageDto> optionalMessageDto = Optional.of(new MessageDto("User1","User2","Sample message",Timestamp.valueOf(LocalDateTime.of(2024,1,29,20,51,0))));

        //When & Then
        assertThat(messageValidator.validate(optionalMessageDto)).isEqualTo(MessageStatus.PARSED);
    }

    @Test
    public void shouldSendMessageStatusNotParsedOnWrongMessage(){
        //Given
        MessageValidator messageValidator = new MessageValidator();
        Optional<MessageDto> optionalMessageDto = Optional.of(new MessageDto(null,"User2","Sample message",Timestamp.valueOf(LocalDateTime.of(2024,1,29,20,51,0))));

        //When & Then
        assertThat(messageValidator.validate(optionalMessageDto)).isEqualTo(MessageStatus.NOT_PARSED);
    }

}