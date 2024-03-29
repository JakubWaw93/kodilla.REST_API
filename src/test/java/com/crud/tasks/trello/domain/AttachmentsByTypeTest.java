package com.crud.tasks.trello.domain;

import com.crud.tasks.domain.AttachmentsByType;
import com.crud.tasks.domain.Trello;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AttachmentsByTypeTest {

    @InjectMocks
    private AttachmentsByType attachmentsByType;

    @Test
    void getDataTest() {
        //Given
        Trello trello = new Trello();
        trello.setBoard(1);
        trello.setCard(1);
        attachmentsByType.setTrello(trello);
        //when
        Trello attachedTrello = attachmentsByType.getTrello();
        //Then
        assertEquals(1, attachedTrello.getCard());
        assertEquals(1, attachedTrello.getBoard());
    }
}
