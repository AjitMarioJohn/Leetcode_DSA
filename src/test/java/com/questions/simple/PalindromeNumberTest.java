package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeNumberTest {

    private static PalindromeNumber palindromeNumber;

    @BeforeEach
    public void initiate(){
        palindromeNumber = new PalindromeNumber();
    }

    @ParameterizedTest
    @ValueSource(ints = {121, 1551,696, 2002, 48084})
    public void testValidPalindromeNumbers(int input){
        Assertions.assertTrue(palindromeNumber.isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, -121,69})
    public void testInValidPalindromeNumbers(int input){
        Assertions.assertFalse(palindromeNumber.isPalindrome(input));
    }

}
