package com.chat.backend.messageproducer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MessageProviderFacadeTest {

    @Test
    void shouldSendListOfMessagesForUserId() {
        //Given
        String userId = "user1";
        List<List<String>> messages = List.of(List.of("Baker","You should buy tomato","2024-02-04 18:00:00"),
                List.of("Johny","Bananas","2024-02-04 18:00:00"));
        MessageRepository messageRepository = new MessageRepositoryStub(userId,messages);
        MessageProviderFacade messageProviderFacade = new MessageProviderFacade(messageRepository);

        //When
        List<List<String>> result = messageProviderFacade.updateMessages(userId);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getFirst()).isEqualTo("Baker");
        assertThat(result.get(1).get(1)).isEqualTo("Bananas");
    }
}