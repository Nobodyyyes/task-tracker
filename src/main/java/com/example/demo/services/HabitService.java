package com.example.demo.services;

import com.example.demo.models.Habit;

import java.util.List;

public interface HabitService {

    Habit createHabit(Habit newHabit);

    Habit getById(Long habitId);

    List<Habit> getAllHabitsByUserId(Long userId);

    Habit updateHabit(Habit updateHabit);

    void deactivateHabit(Long habitId);

    boolean existsById(Long habitId);
}
