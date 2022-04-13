package com.calculator;

public class IncorrectStringException extends Exception {
    public IncorrectStringException() {
        super("incorrect string"); // неверный формат строки, неверная строка
    }
}
