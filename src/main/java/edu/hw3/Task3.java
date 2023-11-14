package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3<T> {
    public Map<T, Integer> freqDict(T[] strings) {
        Map<T, Integer> answer = new HashMap<>();
        for (var cur: strings) {
            if (answer.containsKey(cur)) {
                int oldValue = answer.get(cur);
                int newValue = oldValue + 1;
                answer.put(cur, newValue);
            } else {
                answer.put(cur, 1);
            }
        }
        return answer;
    }
}
