package com.example.demo.services.impl;

import com.example.demo.enums.TaskStatus;
import com.example.demo.exceptions.TaskNotFoundException;
import com.example.demo.mappers.TaskMapper;
import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Override
    public List<Task> getAllTasksByUserId(Long userId) {
        return taskMapper.toModels(taskRepository.findAllByUserId(userId));
    }

    @Override
    public Task getByTaskId(Long taskId) {
        return taskRepository.findById(taskId)
                .map(taskMapper::toModel)
                .orElseThrow(() -> new TaskNotFoundException("Task by ID [%s] not found".formatted(taskId)));
    }

    @Override
    public Task createTask(Task newTask) {
        return null;
    }

    @Override
    public Task updateTask(Task updateTask) {
        return null;
    }

    @Override
    public Task changeTaskStatus(Long taskId, TaskStatus taskStatus) {
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {

    }
}
