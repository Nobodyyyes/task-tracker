package com.example.demo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Tag {
    WORK("Работа"),
    STUDY("Учеба"),
    PERSONAL("Личное"),
    HEALTH("Здоровье"),
    FINANCE("Финансы"),
    DEFAULT("По умолчанию");

    private final String description;
}
