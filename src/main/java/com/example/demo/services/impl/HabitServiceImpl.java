package com.example.demo.services.impl;

import com.example.demo.exceptions.HabitNotFoundException;
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

        Habit habit = Habit.builder()
                .id(newHabit.getId())
                .title(newHabit.getTitle())
                .description(newHabit.getDescription())
                .habitFrequency(newHabit.getHabitFrequency())
                .startDate(newHabit.getStartDate())
                .endDate(newHabit.getEndDate())
                .active(newHabit.isActive())
                .userId(newHabit.getUserId())
                .build();

        return habitMapper.toModel(habitRepository.save(habitMapper.toEntity(habit)));
    }

    @Override
    public Habit getById(Long habitId) {
        return habitRepository.findById(habitId)
                .map(habitMapper::toModel)
                .orElseThrow(() -> new HabitNotFoundException("Habit by ID [%s] not found".formatted(habitId)));
    }

    @Override
    public List<Habit> getAllHabitsByUserId(Long userId) {
        return habitMapper.toModels(habitRepository.findAllByUserId(userId));
    }

    @Override
    public Habit updateHabit(Habit updateHabit) {

        Habit habit = getById(updateHabit.getId());
        habit.setId(updateHabit.getId());
        habit.setTitle(updateHabit.getTitle());
        habit.setDescription(updateHabit.getDescription());
        habit.setHabitFrequency(updateHabit.getHabitFrequency());
        habit.setStartDate(updateHabit.getStartDate());
        habit.setEndDate(updateHabit.getEndDate());
        habit.setActive(updateHabit.isActive());
        habit.setUserId(updateHabit.getUserId());

        return habitMapper.toModel(habitRepository.save(habitMapper.toEntity(habit)));
    }

    @Override
    public void deactivateHabit(Long habitId) {

    }

    @Override
    public boolean existsById(Long habitId) {
        return habitRepository.existsById(habitId);
    }
}
