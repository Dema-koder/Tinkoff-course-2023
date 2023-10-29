package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//magicnumber прописал потому что ругается на аргументы в свитче
@SuppressWarnings({"hideutilityclassconstructor", "multiplestringliterals", "magicnumber"})
public class Task4 {
    private static final int MAX_STRING_SIZE = 4;
    private static final Logger LOGGER = LogManager.getLogger();

    public static String convertToRoman(Integer arabianNumber) throws IllegalArgumentException {
        String str = arabianNumber.toString();
        LOGGER.info("Получили число " + arabianNumber);
        if (!checkArabianNumber(str)) {
            LOGGER.error("Строка не подходит под формат");
            throw new IllegalArgumentException("Строка не корректна");
        }
        LOGGER.info("Строка корректна");
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                continue;
            }
            String cur = convert(str.charAt(i), str.length() - i);
            answers.add(cur);
        }
        return String.join("", answers);
    }

    protected static boolean checkArabianNumber(String number) {
        LOGGER.info("Проверяем строку на корректность");
        if (number.length() > MAX_STRING_SIZE) {
            return false;
        }
        boolean ans = true;
        for (int i = 0; i < number.length(); i++) {
            if (i != 0) {
                ans &= !(number.charAt(i) < '0' || number.charAt(i) > '9');
            } else {
                ans &= !(number.charAt(i) < '0' || number.charAt(i) > '3');
            }
        }
        return ans;
    }

    private static String convert(char digit, int position) {
        String ans = "";
        switch (position) {
            case 1:
                ans = convertUnits(digit);
                break;
            case 2:
                ans = convertDozens(digit);
                break;
            case 3:
                ans = convertHundreds(digit);
                break;
            case 4:
                ans = convertThousands(digit);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return ans;
    }

    private static String convertUnits(char digit) {
        LOGGER.info("Конвертируем единицы " + digit);
        String ans = "";
        switch (digit) {
            case '1':
                ans = "I";
                break;
            case '2':
                ans = "II";
                break;
            case '3':
                ans = "III";
                break;
            case '4':
                ans = "IV";
                break;
            case '5':
                ans = "V";
                break;
            case '6':
                ans = "VI";
                break;
            case '7':
                ans = "VII";
                break;
            case '8':
                ans = "VIII";
                break;
            case '9':
                ans = "IX";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + digit);
        }
        return ans;
    }

    private static String convertDozens(char digit) {
        LOGGER.info("Конвертируем десятки " + digit);
        String ans = "";
        switch (digit) {
            case '1':
                ans = "X";
                break;
            case '2':
                ans = "XX";
                break;
            case '3':
                ans = "XXX";
                break;
            case '4':
                ans = "XL";
                break;
            case '5':
                ans = "L";
                break;
            case '6':
                ans = "LX";
                break;
            case '7':
                ans = "LXX";
                break;
            case '8':
                ans = "LXXX";
                break;
            case '9':
                ans = "XC";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + digit);
        }
        return ans;
    }

    private static String convertHundreds(char digit) {
        LOGGER.info("Конвертируем сотни " + digit);
        String ans;
        switch (digit) {
            case '1':
                ans = "C";
                break;
            case '2':
                ans = "CC";
                break;
            case '3':
                ans = "CCC";
                break;
            case '4':
                ans = "CD";
                break;
            case '5':
                ans = "D";
                break;
            case '6':
                ans = "DC";
                break;
            case '7':
                ans = "DCC";
                break;
            case '8':
                ans = "DCCC";
                break;
            case '9':
                ans = "CM";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + digit);
        }
        return ans;
    }

    private static String convertThousands(char digit) {
        LOGGER.info("Конвертируем тысячи " + digit);
        switch (digit) {
            case '1':
                return "M";
            case '2':
                return "MM";
            case '3':
                return "MMM";
            default:
                throw new IllegalStateException("Unexpected value: " + digit);
        }
    }
}
