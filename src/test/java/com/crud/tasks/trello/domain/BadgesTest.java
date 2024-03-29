package com.crud.tasks.trello.domain;

import com.crud.tasks.domain.AttachmentsByType;
import com.crud.tasks.domain.Badges;
import com.crud.tasks.domain.Trello;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BadgesTest {

    @InjectMocks
    private Badges badges;

    @Test
    void getDataFromBadgesTest() {
        //Given
        Trello trello = new Trello();
        trello.setCard(12);
        trello.setBoard(2);
        AttachmentsByType attachmentsByType = new AttachmentsByType();
        attachmentsByType.setTrello(trello);
        badges.setVotes(1);
        badges.setAttachmentsByType(attachmentsByType);
        //when&Then
        assertEquals(1, badges.getVotes());
        assertEquals(12, badges.getAttachmentsByType().getTrello().getCard());


    }
}
