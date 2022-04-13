package com.calculator;

public class OutOfRangeException extends Exception {
    public OutOfRangeException() {
        super("one of the numbers is more than 10 or less than 1"); // введённые числа вне диапазона от 1 до 10
    }
}
