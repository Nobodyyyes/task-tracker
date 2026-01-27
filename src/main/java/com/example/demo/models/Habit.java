package com.example.demo.models;

import com.example.demo.enums.HabitFrequency;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Habit {

    private Long id;
    private String title;
    private String description;
    private HabitFrequency habitFrequency;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
    private Long userId;
}
