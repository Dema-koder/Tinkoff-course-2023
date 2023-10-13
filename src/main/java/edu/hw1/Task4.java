package edu.hw1;

@SuppressWarnings("hideutilityclassconstructor")
public class Task4 {

    static String fixString(String str) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < str.length(); i += 2) {
            if (i != str.length() - 1) {
                char temp = charArr[i];
                charArr[i] = charArr[i + 1];
                charArr[i + 1] = temp;
            }
        }
        String ans = new String(charArr);
        return ans;
    }
}
