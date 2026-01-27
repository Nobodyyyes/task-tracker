package com.example.demo.services.impl;

import com.example.demo.mappers.HabitMapper;
import com.example.demo.models.Habit;
import com.example.demo.repositories.HabitRepository;
import com.example.demo.services.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;

    private final HabitMapper habitMapper;

    @Override
    public Habit createHabit(Habit newHabit) {
        return null;
    }

    @Override
    public Habit getById(Long habitId) {
        return null;
    }

    @Override
    public List<Habit> getAllHabitsByUserId(Long userId) {
        return List.of();
    }

    @Override
    public Habit updateHabit(Habit updateHabit) {
        return null;
    }

    @Override
    public void deactivateHabit(Long habitId) {

    }
}
