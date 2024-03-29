package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "TestTitle", "TestContent");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1L, task.getId());
        assertEquals("TestTitle", task.getTitle());
        assertEquals("TestContent", task.getContent());
    }

    @Test
    void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "TestTitle", "TestContent");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(1L, taskDto.getId());
        assertEquals("TestTitle", taskDto.getTitle());
        assertEquals("TestContent", taskDto.getContent());
    }

    @Test
    void mapToTaskDtoListTest() {
        //Given
        Task task1 = new Task(1L, "TestTitle", "TestContent");
        Task task2 = new Task(2L, "TestTitle2", "TestContent2");
        List<Task> tasks = List.of(task1, task2);
        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertEquals(2, taskDtos.size());
        assertEquals(2L, taskDtos.get(1).getId());
        assertEquals("TestTitle2", taskDtos.get(1).getTitle());
        assertEquals("TestContent2", taskDtos.get(1).getContent());
    }
}
