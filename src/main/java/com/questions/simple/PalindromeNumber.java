package com.questions.simple;

public class PalindromeNumber {
    public boolean isPalindrome(int input) {
        return Integer.toString(input).equals(new StringBuffer(String.valueOf(input)).reverse().toString());
    }
}
