package com.example.demo.controllers;

import com.example.demo.models.Habit;
import com.example.demo.services.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/habits")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @GetMapping("/{userId}")
    public List<Habit> getAllHabitsByUserId(@PathVariable Long userId) {
        return habitService.getAllHabitsByUserId(userId);
    }

    @GetMapping("/{habitId}")
    public Habit getHabitById(@PathVariable Long habitId) {
        return habitService.getById(habitId);
    }

    @PostMapping
    public Habit createHabit(@RequestBody Habit newHabit) {
        return habitService.createHabit(newHabit);
    }

    @PutMapping
    public Habit updateHabit(@RequestBody Habit updateHabit) {
        return habitService.updateHabit(updateHabit);
    }

    @PutMapping("/deactivate/{habitId}")
    public void deactivateHabit(@PathVariable Long habitId) {
        habitService.deactivateHabit(habitId);
    }
}
