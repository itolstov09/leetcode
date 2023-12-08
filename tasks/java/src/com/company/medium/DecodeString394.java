package com.company.medium;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString394 {
    public static void main(String[] args) {
        String ms1 = mySolution("3[a]2[bc]");
        assert ms1.equals("aaabcbc") : "mySolution 1 failed";
        String ms2 = mySolution("3[a2[c]]");
        assert ms2.equals("accaccacc") : "mySolution 2 failed";
        assert mySolution("2[abc]3[cd]ef").equals("abcabccdcdcdef") : "mySolution 3 failed";
        assert mySolution("300[a2[s]]").equals("assassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassassass") : "mySolution 4 failed";
        assert mySolution("abc3[cd]xyz").equals("abccdcdcdxyz") : "mySolution 5 failed";
        assert mySolution("3").equals("");
        assert mySolution("a").equals("a");

        System.out.println("All good");
    }

    private static String mySolution(String encoded) {
        /*
        найти самую правую открытую скобку.
        если есть,
            парсим число.
                индекс открытой скобки-1 считать за индекс последнего разряда числа
                идти влево, пока i-ый символ - цифра
            идти от индекса открытой скобки, пока не будет найден индекс закрытой скобки.
            индекс открытой скобки + 1 считать началом подстроки для расшифровки
            индекс закрытой скобки - 1 считать концом подстроки для расшифровки

         */
        int openedBraceIndex = encoded.lastIndexOf('[');
        if (openedBraceIndex == -1) {
            if (encoded.matches("[0-9]+")) {
                return "";
            }

            return encoded;
        }

        int numberLastDigitIndex = openedBraceIndex - 1;
        int numberTopDigitIndex = numberLastDigitIndex;


        while (numberTopDigitIndex > 0) {
            char ch = encoded.charAt(numberTopDigitIndex - 1);
            if (!Character.isDigit(ch)) {
                break;
            }

            numberTopDigitIndex--;
        }

        String substring = encoded.substring(numberTopDigitIndex, numberLastDigitIndex + 1);
        int repeatCount = Integer.parseInt(substring);
        int closedBraceIndex = encoded.indexOf(']', openedBraceIndex);

        String symbols = encoded.substring(openedBraceIndex + 1, closedBraceIndex);

        String decoded = symbols.repeat(repeatCount);

        String rightPart;
        int rightPartStartIndex = closedBraceIndex + 1;
        if (rightPartStartIndex == encoded.length()) {
            rightPart = "";
        } else {
            rightPart = encoded.substring(rightPartStartIndex);
        }
//        если индекс верхнего разряда числа = 0, то расшифрованная часть является финальной
        if (numberTopDigitIndex == 0) {
            return decoded + rightPart;
        }

        String leftPart = encoded.substring(0, numberTopDigitIndex);
        String recursive = leftPart + decoded + rightPart;
        return mySolution(recursive);
    }
}
