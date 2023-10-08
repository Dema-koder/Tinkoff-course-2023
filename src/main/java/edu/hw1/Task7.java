package edu.hw1;

import java.util.ArrayList;

@SuppressWarnings("hideutilityclassconstructor")
public class Task7 {

    static Integer rotateRight(Integer n, Integer k) {
        String s = getBinary(n);
        char[] bin = s.toCharArray();
        char[] temp = new char[s.length()];
        for (int i = k; i < s.length(); i++) {
            temp[i] = bin[i - k];
        }
        for (int i = 0; i < k; i++) {
            temp[i] = bin[k + i];
        }
        String t = new String(temp);
        Integer ans = fromBinaryToDecimal(t);
        return ans;
    }

    static Integer rotateLeft(Integer n, Integer k) {
        String s = getBinary(n);
        char[] bin = s.toCharArray();
        char[] temp = new char[s.length()];
        for (int i = 0; i < s.length() - k; i++) {
            temp[i] = bin[i + k];
        }
        for (int i = s.length() - k; i < s.length(); i++) {
            temp[i] = bin[i - s.length() + k];
        }
        String t = new String(temp);
        Integer ans = fromBinaryToDecimal(t);
        return ans;
    }

    static String getBinary(Integer cur) {
        Integer num = cur;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (num > 0) {
            arr.add(num % 2);
            num /= 2;
        }
        ArrayList<Integer> revArr = new ArrayList<Integer>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            revArr.add(arr.get(i));
        }
        char[] s = new char[arr.size()];
        for (int i = 0; i < revArr.size(); i++) {
            s[i] = (char) (revArr.get(i) + '0');
        }
        String ans = new String(s);
        return ans;
    }

    static Integer fromBinaryToDecimal(String bin) {
        int k = 1;
        int ans = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            ans += k * (bin.charAt(i) - '0');
            k *= 2;
        }
        return ans;
    }
}
