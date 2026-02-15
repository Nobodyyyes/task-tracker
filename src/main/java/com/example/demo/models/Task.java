package com.example.demo.models;

import com.example.demo.enums.Tag;
import com.example.demo.enums.TaskPriority;
import com.example.demo.enums.TaskStatus;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate dueDate;
    private Long userId;
    private Tag tag;
}
