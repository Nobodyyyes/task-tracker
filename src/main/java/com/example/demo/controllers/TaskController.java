package com.example.demo.controllers;

import com.example.demo.enums.TaskStatus;
import com.example.demo.models.Task;
import com.example.demo.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{userId}")
    public List<Task> getAllTaskByUserId(@PathVariable Long userId) {
        return taskService.getAllTasksByUserId(userId);
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getByTaskId(taskId);
    }

    @PostMapping
    public Task createNewTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping
    public Task updateTask(Task task) {
        return taskService.updateTask(task);
    }

    @PutMapping("/taskId/{taskId}/taskStatus/{taskStatus}")
    public Task changeTaskStatus(@PathVariable Long taskId, @PathVariable TaskStatus taskStatus) {
        return taskService.changeTaskStatus(taskId, taskStatus);
    }

    @DeleteMapping
    public void deleteTask(Long taskId) {
        taskService.deleteTask(taskId);
    }
}
