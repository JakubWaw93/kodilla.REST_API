package com.crud.tasks.trello.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;
    @Mock
    private TrelloClient trelloClient;

    @Test
    void fetchTrelloBoardsTest() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("TestBoard");
        List<TrelloBoardDto> trelloBoardDtos = List.of(trelloBoardDto);
        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);
        //When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(1, fetchedTrelloBoards.size());
        assertEquals("1", fetchedTrelloBoards.get(0).getId());
        assertEquals("TestBoard", fetchedTrelloBoards.get(0).getName());
    }
}

