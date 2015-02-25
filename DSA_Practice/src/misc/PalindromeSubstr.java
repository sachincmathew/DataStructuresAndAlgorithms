package misc;


import sun.applet.Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SachinMathew
 */
public class PalindromeSubstr {

    public static void main(String[] args) {
        String input = "imasmalayalamsachin";
        System.out.println(getLongestPalindromeSubstr(input));

    }

    static String getLongestPalindromeSubstr(String input) {
        if (input.isEmpty()) {
            return null;
        }

        if (input.length() == 1) {
            return input;
        }
        
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            String current = "" + input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                current += input.charAt(j);
                if (isPalindrome(current)) {
                    if (current.length() > output.length()) {
                        output = current;
                    }
                }
            }
        }
        return output;
    }

    static boolean isPalindrome(String input) {
        StringBuilder strBufInput = new StringBuilder(input);
        String reversedInput;
        reversedInput = strBufInput.reverse().toString();
        return input.equalsIgnoreCase(reversedInput);
    }
}
