package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Validate {

    @InjectMocks
    private TrelloValidator trelloValidator;

    @Test
    void validateCartTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("NotATestName", "LegitDescription", "top", "1");
        TrelloCard testingTrelloCard = new TrelloCard("test", "TestDescription", "TestPosition", "0");
        //When&Then
        trelloValidator.validateCard(trelloCard);
        trelloValidator.validateCard(testingTrelloCard);
    }

    @Test
    void validateTrelloBoardsTest() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "notATestName", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "Test", new ArrayList<>());
        List<TrelloBoard> trelloBoards = List.of(trelloBoard1, trelloBoard2);
        //When
        List<TrelloBoard> validatedTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertEquals(1, validatedTrelloBoards.size());
    }

}
