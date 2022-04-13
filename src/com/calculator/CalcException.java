package com.calculator;

public class CalcException extends Exception {
    public CalcException(String description) {
        super(description); // для прочих или единичных исключений
    }
}
