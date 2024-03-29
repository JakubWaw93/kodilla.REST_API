package com.crud.tasks.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AdminConfigTest {

    @InjectMocks
    private AdminConfig adminConfig;

    @Test
    void adminConfigRetrieveDataTest() {
        //Given
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(adminConfig, "adminMail", "TestAdminMail");
        //When&Then
        assertEquals("TestAdminMail", adminConfig.getAdminMail());
    }
}
