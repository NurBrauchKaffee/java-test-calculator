package com.calculator;

public class NumConverting {
    public static int toArabic(String num) throws OutOfRangeException{
        int res;

        switch (num) { // в списке присутствуют и арабские числа для проверки римского числа, если оно больше 10
            case "I", "i", "1" -> res = 1;
            case "II", "ii", "2" -> res = 2;
            case "III", "iii", "3" -> res = 3;
            case "IV", "iv", "4" -> res = 4;
            case "V", "v", "5" -> res = 5;
            case "VI", "vi", "6" -> res = 6;
            case "VII", "vii", "7" -> res = 7;
            case "VIII", "viii", "8" -> res = 8;
            case "IX", "ix", "9" -> res = 9;
            case "X", "x", "10" -> res = 10;
            default -> throw new OutOfRangeException();
        }

        return res;
    }

    public static String toRoman (int num) { // возвращаем римское число по его индексу в массиве; чисел больше ста в ответе быть не может
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[num];
    }
}
