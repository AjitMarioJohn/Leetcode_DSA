package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.time.Duration;
import java.time.Instant;

public class LongestCommonPrefixTest {

    private LongestCommonPrefix longestCommonPrefix;

    @BeforeEach
    private void initialize(){
        this.longestCommonPrefix = new LongestCommonPrefix();
    }

    @ParameterizedTest
    @DisplayName("LongestCommonPrefix should ")
    @CsvSource(value = {"abcabcbb:3", "bbbbb:1", "pwwkew:3", "abcabcbbabcabcbbabcabcbb:3",":0"}, delimiter = ':')
    public void testLongestCommonPrefix(String input, int output){
        Assertions.assertEquals(output, this.longestCommonPrefix.lengthOfLongestSubstring(input));
    }

    @Test
    @NullAndEmptySource
    public void testLongestCommonPrefixForNullAndEmpty(String input){
        Assertions.assertEquals(0, this.longestCommonPrefix.lengthOfLongestSubstring(input));
    }

}
