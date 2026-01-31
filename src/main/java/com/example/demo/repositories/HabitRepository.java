package com.example.demo.repositories;

import com.example.demo.entities.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<HabitEntity, Long> {

    List<HabitEntity> findAllByUserId(Long userId);
}
