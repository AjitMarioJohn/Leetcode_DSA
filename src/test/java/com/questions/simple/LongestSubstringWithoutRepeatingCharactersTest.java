package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LongestSubstringWithoutRepeatingCharactersTest {

    static LongestSubstringWithoutRepeatingCharacters obj;

    @BeforeEach
    void initialize(){
        obj = new LongestSubstringWithoutRepeatingCharacters();
    }

    @ParameterizedTest
    @DisplayName("LongestCommonPrefix should ")
    @CsvSource(value = {"abcabcbb:3", "bbbbb:1", "pwwkew:3", "abcabcbbabcabcbbabcabcbb:3",":0", "' ':1"}, delimiter = ':')
    public void testLongestCommonPrefix(String input, int output){
        Assertions.assertEquals(output, this.obj.lengthOfLongestSubstring(input));
    }

    @Test
    @NullAndEmptySource
    public void testLongestCommonPrefixForNullAndEmpty(String input){
        Assertions.assertEquals(0, this.obj.lengthOfLongestSubstring(input));
    }

}
