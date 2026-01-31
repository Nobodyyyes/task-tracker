package com.example.demo.exceptions;

public class HabitAlreadyExistsException extends RuntimeException {

    public HabitAlreadyExistsException(String message) {
        super(message);
    }
}
