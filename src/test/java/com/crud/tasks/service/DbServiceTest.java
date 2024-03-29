package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class DbServiceTest {

    @Autowired
    private DbService dbService;
    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void clearAll() {
        taskRepository.deleteAll();
    }
    @AfterEach
    void clearAllAgain() {
        taskRepository.deleteAll();
    }

    @Test
    void saveTaskAndFindByIdTest() throws TaskNotFoundException {
        //Given
        Task task = new Task("TestTitle", "TestContent");
        //When
        dbService.saveTask(task);
        long taskId = task.getId();
        Task retrievedTask = dbService.getTask(taskId);
        //Then
        assertNotNull(task.getId());
        assertEquals("TestTitle", retrievedTask.getTitle());
        assertEquals("TestContent", retrievedTask.getContent());

    }

    @Test
    void getAllTaskTest() {
        //Given
        Task task1 = new Task("TestTitle", "TestContent");
        Task task2 = new Task("TestTitle2", "TestContent2");
        dbService.saveTask(task1);
        dbService.saveTask(task2);
        //When
        List<Task> tasks = dbService.getAllTasks();
        //Then
        assertEquals(2, tasks.size());
        assertEquals("TestTitle", tasks.get(0).getTitle());
        assertEquals("TestContent", tasks.get(0).getContent());
        assertEquals("TestTitle2", tasks.get(1).getTitle());
        assertEquals("TestContent2", tasks.get(1).getContent());
    }

    @Test
    void deleteTaskTest() throws TaskNotFoundException {
        //Given
        Task task1 = new Task("TestTitle", "TestContent");
        Task task2 = new Task("TestTitle2", "TestContent2");
        dbService.saveTask(task1);
        dbService.saveTask(task2);
        long task2Id = task2.getId();
        //When
        dbService.deleteTask(task2Id);
        List<Task> tasks = dbService.getAllTasks();
        //Then
        assertEquals(1,tasks.size());
    }

    @Test
    void throwExceptionTest() {
        //Given
        //When&Then
        assertThrows(TaskNotFoundException.class, () -> dbService.getTask(1L));
    }

}
