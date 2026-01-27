package com.example.demo.entities;

import com.example.demo.enums.TaskPriority;
import com.example.demo.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "TASKS")
public class TaskEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TASKS_SEQ", sequenceName = "TASKS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TASK_STATUS")
    private TaskStatus taskStatus;

    @Column(name = "PRIORITY")
    private TaskPriority taskPriority;

    @Column(name = "DUE_DATE")
    private LocalDateTime dueDate;

    @Column(name = "USER_ID")
    private Long userId;
}
