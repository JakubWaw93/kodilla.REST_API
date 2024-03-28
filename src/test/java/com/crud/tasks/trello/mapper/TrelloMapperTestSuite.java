package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TrelloMapperTestSuite {

  @InjectMocks
  TrelloMapper trelloMapper;

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "testName",
                "testDescription",
                "testPos",
                "testId"
        );
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("testName", trelloCard.getName());
        assertEquals("testDescription", trelloCard.getDescription());
        assertEquals("testPos", trelloCard.getPos());
        assertEquals("testId", trelloCard.getListId());

    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard(
                "testName",
                "testDescription",
                "testPos",
                "testId"
        );
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("testName", trelloCardDto.getName());
        assertEquals("testDescription", trelloCardDto.getDescription());
        assertEquals("testPos", trelloCardDto.getPos());
        assertEquals("testId", trelloCardDto.getListId());

    }

    @Test
    void testMapToListDto() {
        //Given
        TrelloList firstList = new TrelloList("firstListId", "firstListName", false);
        TrelloList secondList = new TrelloList("secondListId", "secondListName", true);
        List<TrelloList> trelloLists = new ArrayList<>(List.of(firstList, secondList));
        //When
        List<TrelloListDto> trelloListsDtos = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(2, trelloListsDtos.size());
        assertEquals("firstListId", trelloListsDtos.get(0).getId());
        assertEquals("firstListName", trelloListsDtos.get(0).getName());
        assertFalse(trelloListsDtos.get(0).isClosed());
        assertEquals("secondListId", trelloListsDtos.get(1).getId());
        assertEquals("secondListName", trelloListsDtos.get(1).getName());
        assertTrue(trelloListsDtos.get(1).isClosed());
    }

    @Test
    void testMapToList() {
        //Given
        TrelloListDto firstListDto = new TrelloListDto("firstListId", "firstListName", false);
        TrelloListDto secondListDto = new TrelloListDto("secondListId", "secondListName", true);
        List<TrelloListDto> trelloListsDtos = new ArrayList<>(List.of(firstListDto, secondListDto));
        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListsDtos);
        //Then
        assertEquals(2, trelloLists.size());
        assertEquals("firstListId", trelloLists.get(0).getId());
        assertEquals("firstListName", trelloLists.get(0).getName());
        assertFalse(trelloLists.get(0).isClosed());
        assertEquals("secondListId", trelloLists.get(1).getId());
        assertEquals("secondListName", trelloLists.get(1).getName());
        assertTrue(trelloLists.get(1).isClosed());
    }

    @Test
    void testMapToBoardsDto() {
        //Given
        TrelloList firstList = new TrelloList("firstListId", "firstListName", false);
        TrelloList secondList = new TrelloList("secondListId", "secondListName", true);
        List<TrelloList> trelloLists = new ArrayList<>(List.of(firstList, secondList));
        TrelloBoard trelloBoard = new TrelloBoard("boardId", "boardName", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>(List.of(trelloBoard));
        //When
        List<TrelloBoardDto> trelloBoardsDtos = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        assertEquals(1, trelloBoardsDtos.size());
        assertEquals(2, trelloBoardsDtos.get(0).getLists().size());
        assertEquals("secondListId", trelloBoardsDtos.get(0).getLists().get(1).getId());
        assertEquals("secondListName", trelloBoardsDtos.get(0).getLists().get(1).getName());
        assertTrue(trelloBoardsDtos.get(0).getLists().get(1).isClosed());
    }

    @Test
    void testMapToBoards() {
        //Given
        TrelloListDto firstListDto = new TrelloListDto("firstListId", "firstListName", false);
        TrelloListDto secondListDto = new TrelloListDto("secondListId", "secondListName", true);
        List<TrelloListDto> trelloListsDtos = new ArrayList<>(List.of(firstListDto, secondListDto));
        TrelloBoardDto trelloBoard = new TrelloBoardDto("boardId", "boardName", trelloListsDtos);
        List<TrelloBoardDto> trelloBoardsDtos = new ArrayList<>(List.of(trelloBoard));
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDtos);
        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals(2, trelloBoards.get(0).getLists().size());
        assertEquals("secondListId", trelloBoards.get(0).getLists().get(1).getId());
        assertEquals("secondListName", trelloBoards.get(0).getLists().get(1).getName());
        assertTrue(trelloBoards.get(0).getLists().get(1).isClosed());
    }
}
