package com.calculator;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in); // подключаем ввод из консоли
    static String num1, num2; // числа
    static char operator; // знак: "+", "-", "/" или "*"
    static String result; // результат

    public static void main(String[] args) throws CalcException, OutOfRangeException, IncorrectStringException {
        String input = in.nextLine(); // вводим выражение
        System.out.println(Main.calc(input)); // выводим результат
    }

    public static String calc(String input) throws CalcException, OutOfRangeException, IncorrectStringException {
        char[] buffer = bufferProcessing(input); // заводим строку в буфер, обрабатываем
        String bufferStr = String.valueOf(buffer); // переносим значение из массива знаков в строку
        String[] splitBuffer = bufferStr.split("[+-/*]"); // разделяем строку по знаку, оставляя два числа

        num1 = splitBuffer[0].trim();
        num2 = splitBuffer[1].trim();

        if (isRoman(num1) != isRoman(num2)) // проверка на тип чисел: одновременно арабские или одновременно римские
            throw new CalcException("roman and arabic numbers cannot stay together in the expression");

        if (isRoman(num1)) { // проверка на тип чисел: если римские, то вычисляем "римским" способом, если арабские, то "арабским"
            result = Calculation.calculateRoman(num1, num2, operator);
        } else {
            result = Calculation.calculateArabic(num1, num2, operator);
        }

        return result;
    }

    public static boolean isRoman(String num) throws OutOfRangeException {
        String[] romanVoc = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; // "словарь" римских чисел

        for (String s : romanVoc) { // проверка числа на соответствие римским числам
            if (num.equals(s)) {
                return true;
            }
        }

        NumConverting.toArabic(num); // проверка римского числа, если оно больше 10

        return false;
    }

    public static char[] bufferProcessing(String input) throws IncorrectStringException {
        char[] buffer = new char[10]; // создаём буфер

        try {
            for (int i = 0; i < input.length(); i++) {
                buffer[i] = input.charAt(i);
                switch (buffer[i]) {
                    case '+' -> operator = '+';
                    case '-' -> operator = '-';
                    case '*' -> operator = '*';
                    case '/' -> operator = '/';
                    case '1', '2', '3', '4', '5', '6', '7', '8', '9', 'I', 'i', 'V', 'v', 'X', 'x', ' ' -> {
                    }
                    default -> throw new IncorrectStringException(); // если в строке находится "ненужный" знак, выбрасываем исключение
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IncorrectStringException(); // выбрасываем исключение, если слишком длинная строка
        }

        return buffer; // возвращаем обработанный буфер
    }
}
