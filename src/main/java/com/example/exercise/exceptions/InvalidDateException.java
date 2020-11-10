package com.example.exercise.exceptions;

public class InvalidDateException extends RuntimeException{

    public InvalidDateException() {
        super("The entered date is not valid");
    }

}
