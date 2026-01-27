package com.example.demo.services.impl;

import com.example.demo.enums.TaskStatus;
import com.example.demo.exceptions.TaskAlreadyExistsException;
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

        if (existsById(newTask.getId())) {
            throw new TaskAlreadyExistsException("Task by ID [%s] already exists");
        }

        return taskMapper.toModel(taskRepository.save(taskMapper.toEntity(newTask)));
    }

    @Override
    public Task updateTask(Task updateTask) {
        Task task = getByTaskId(updateTask.getId());

        task.setId(updateTask.getId());
        task.setTitle(updateTask.getTitle());
        task.setDescription(updateTask.getDescription());
        task.setTaskStatus(updateTask.getTaskStatus());
        task.setTaskPriority(updateTask.getTaskPriority());
        task.setDueDate(updateTask.getDueDate());
        task.setUserId(updateTask.getUserId());

        return taskMapper.toModel(taskRepository.save(taskMapper.toEntity(task)));
    }

    @Override
    public Task changeTaskStatus(Long taskId, TaskStatus taskStatus) {
        Task task = getByTaskId(taskId);
        task.setTaskStatus(taskStatus);

        return taskMapper.toModel(taskRepository.save(taskMapper.toEntity(task)));
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public boolean existsById(Long id) {
        return taskRepository.existsById(id);
    }
}
