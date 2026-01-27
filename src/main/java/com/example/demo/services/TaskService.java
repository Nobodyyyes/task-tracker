package com.example.demo.services;

import com.example.demo.enums.TaskStatus;
import com.example.demo.models.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasksByUserId(Long userId);

    Task getByTaskId(Long taskId);

    Task createTask(Task newTask);

    Task updateTask(Task updateTask);

    Task changeTaskStatus(Long taskId, TaskStatus taskStatus);

    void deleteTask(Long taskId);

    boolean existsById(Long id);
}
