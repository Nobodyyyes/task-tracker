package com.example.demo.mappers;

import com.example.demo.entities.HabitEntity;
import com.example.demo.models.Habit;
import org.springframework.stereotype.Component;

@Component
public class HabitMapper implements BaseMapper<Habit, HabitEntity> {

    @Override
    public Habit toModel(HabitEntity entity) {
        if (entity == null) return null;

        return Habit.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .habitFrequency(entity.getHabitFrequency())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .active(entity.isActive())
                .userId(entity.getUserId())
                .build();
    }

    @Override
    public HabitEntity toEntity(Habit model) {
        if (model == null) return null;

        return HabitEntity.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .habitFrequency(model.getHabitFrequency())
                .startDate(model.getStartDate())
                .endDate(model.getEndDate())
                .active(model.isActive())
                .userId(model.getUserId())
                .build();
    }
}
