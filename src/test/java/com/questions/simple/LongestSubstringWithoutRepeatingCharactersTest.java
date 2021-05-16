package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LongestSubstringWithoutRepeatingCharactersTest {

    static LongestSubstringWithoutRepeatingCharacters obj;

    @BeforeEach
    void initialize(){
        obj = new LongestSubstringWithoutRepeatingCharacters();
    }

    @ParameterizedTest
    @CsvSource(value = {"abcabcbb:3","bbbbb:1","pwwkew:3"}, delimiter = ':')
    public void validTest(String input, int output){
        Assertions.assertEquals(output, obj.lengthOfLongestSubstring(input));
    }

}
