package com.example.demo.repositories;

import com.example.demo.entities.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<HabitEntity, Long> {
}
