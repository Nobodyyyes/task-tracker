package com.example.demo.models;

import com.example.demo.enums.TaskPriority;
import com.example.demo.enums.TaskStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private Long id;
    private String title;
    private String description;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private LocalDateTime dueDate;
    private Long userId;
}
