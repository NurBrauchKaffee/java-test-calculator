package com.calculator;

public class Calculation {
    public static String calculateRoman(String num1, String num2, char op) throws CalcException, OutOfRangeException { // вычисление римских чисел
        int firstOp = NumConverting.toArabic(num1); // переводим оба числа в арабские числа
        int secondOp = NumConverting.toArabic(num2);
        int res;
        switch (op) {
            case '+' -> res = firstOp + secondOp;
            case '-' -> res = firstOp - secondOp;
            case '*' -> res = firstOp * secondOp;
            case '/' -> res = firstOp / secondOp;
            default -> throw new CalcException("unknown operator");
        }
        if (res < 1) {
            throw new CalcException("result of calculating roman numbers cannot be below zero!"); // выбрасываем исключение, если результат меньше единицы
        }
        return NumConverting.toRoman(res);
    }

    public static String calculateArabic(String num1, String num2, char op) throws CalcException, OutOfRangeException { // вычисление арабских чисел
        int firstOp = Integer.parseInt(num1); // переводим оба числа из строки в арабские числа
        int secondOp = Integer.parseInt(num2);
        int res;
        if (firstOp >= 10 || firstOp < 1 || secondOp >= 10 || secondOp < 1) { // проверка на соответствие диапазону от 1 до 10
            throw new OutOfRangeException();
        }
        switch (op) {
            case '+' -> res = firstOp + secondOp;
            case '-' -> res = firstOp - secondOp;
            case '*' -> res = firstOp * secondOp;
            case '/' -> res = firstOp / secondOp;
            default -> throw new CalcException("unknown operator");
        }
        return Integer.toString(res);
    }
}
