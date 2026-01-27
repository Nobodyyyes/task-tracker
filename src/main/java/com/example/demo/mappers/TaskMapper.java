package com.example.demo.mappers;

import com.example.demo.entities.TaskEntity;
import com.example.demo.models.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements BaseMapper<Task, TaskEntity> {

    @Override
    public Task toModel(TaskEntity entity) {
        if (entity == null) return null;

        return Task.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .taskStatus(entity.getTaskStatus())
                .taskPriority(entity.getTaskPriority())
                .dueDate(entity.getDueDate())
                .userId(entity.getUserId())
                .build();
    }

    @Override
    public TaskEntity toEntity(Task model) {
        if (model == null) return null;

        return TaskEntity.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .taskStatus(model.getTaskStatus())
                .taskPriority(model.getTaskPriority())
                .dueDate(model.getDueDate())
                .userId(model.getUserId())
                .build();
    }
}
