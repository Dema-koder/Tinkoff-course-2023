package edu.hw3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

@SuppressWarnings("innertypelast")
public class Task2 {

    private static boolean checkString(String str) {
        Set<Character> set = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        Set<Character> temp = new HashSet<>();
        temp.add('(');
        temp.add(')');
        if (temp.containsAll(set)) {
            return true;
        }
        return false;
    }

    static class IncorrectStringException extends Exception {
        IncorrectStringException(String message) {
            super(message);
        }
    }

    public ArrayList<String> clusterize(String str) throws IncorrectStringException {
        if (!checkString(str)) {
            throw new IncorrectStringException("Неправильная строка для кластеризации");
        }
        Stack<Character> stack = new Stack<>();
        int prevIndex = 0;
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            }
            if (str.charAt(i) == ')' && !stack.empty()) {
                stack.pop();
            }
            if (stack.empty()) {
                answer.add(str.substring(prevIndex, i + 1));
                prevIndex = i + 1;
            }
        }
        return answer;
    }
}
