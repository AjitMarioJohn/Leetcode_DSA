package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestCommonPrefixTest {

    private LongestCommonPrefix longestCommonPrefix;

    public static Stream<Arguments> input(){
        return Stream.of(
          Arguments.of(new String[]{"flower","flow","flight"}, "fl"),
          Arguments.of(new String[]{"dog","racecar","car"}, ""),
          Arguments.of(new String[]{"a"}, "a")
        );
    }

    @BeforeEach
    private void initialize(){
        longestCommonPrefix = new LongestCommonPrefix();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testLongestCommonPrefix(String[] input, String output){
        Assertions.assertEquals(output, longestCommonPrefix.longestCommonPrefix(input));
    }

}
