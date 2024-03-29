package com.crud.tasks.config;

import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrelloConfigTest {


    @InjectMocks
    private TrelloConfig trelloConfig;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(trelloConfig, "trelloApiEndpoint", "TestApiEndpoint");
        ReflectionTestUtils.setField(trelloConfig, "trelloAppKey", "TestAppKey");
        ReflectionTestUtils.setField(trelloConfig, "trelloToken", "TestToken");
        ReflectionTestUtils.setField(trelloConfig, "trelloUsername", "TestUser");
    }

    @Test
    void configRetrievedDataTest() {
        // Given
        // When & Then
        assertEquals("TestUser", trelloConfig.getTrelloUsername());
        assertEquals("TestAppKey", trelloConfig.getTrelloAppKey());
        assertEquals("TestApiEndpoint", trelloConfig.getTrelloApiEndpoint());
        assertEquals("TestToken", trelloConfig.getTrelloToken());
    }
}
