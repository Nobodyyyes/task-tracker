package com.example.demo.entities;

import com.example.demo.enums.HabitFrequency;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "HABITS")
public class HabitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "HABIT_SEQ", sequenceName = "HABIT_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "HABIT_FREQUENCY")
    @Enumerated(EnumType.STRING)
    private HabitFrequency habitFrequency;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "IS_ACTIVE")
    private boolean active;

    @Column(name = "USER_ID")
    private Long userId;
}
