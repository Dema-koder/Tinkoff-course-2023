package edu.hw5;

import java.util.regex.Pattern;

@SuppressWarnings("hideutilityclassconstructor")
public class Task8 {
    // нечетной длины
    public static boolean isValidString1(String string) {
        return Pattern.matches("^(00|01|10|11)*(0|1)$", string);
    }

    // начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину
    public static boolean isValidString2(String string) {
        return Pattern.matches("^((0(00|01|10|11)*)|(1(00|01|11|10)*(0|1)))$", string);
    }

    // количество 0 кратно 3
    public static boolean isValidString3(String string) {
        return Pattern.matches("^(1*01*01*01*)*$", string);
    }

    // любая строка, кроме 11 или 111
    public static boolean isValidString4(String string) {
        return Pattern.matches("^(?!11$|111$)[01]+$", string);
    }

    // каждый нечетный символ равен 1
    public static boolean isValidString5(String string) {
        return Pattern.matches("^(10|11)*(11|10|1)$", string);
    }

    // содержит не менее двух 0 и не более одной 1
    public static boolean isValidString6(String string) {
        return Pattern.matches("^((10{2,})|(0{2,})|(0{2,}1)|(0{1,}10{1,}))$", string);
    }

    // нет последовательных 1
    public static boolean isValidString7(String string) {
        return Pattern.matches("^((010|0)*(1)0{1,}1?)*$", string);
    }
}
