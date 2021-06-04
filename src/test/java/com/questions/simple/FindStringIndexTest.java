package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FindStringIndexTest {

    private static final String INPUT_11 = "hello";
    private static final String INPUT_12 = "ll";
    private static final int OUTPUT_1 = 2;
    private static final String INPUT_21 = "aaaaa";
    private static final String INPUT_22 = "bba";
    private static final int OUTPUT_2 = -1;
    private FindStringIndex findStringIndex;

    public static Stream<Arguments> inputs(){
        return Stream.of(
                Arguments.of(INPUT_11,INPUT_12, OUTPUT_1),
                Arguments.of(INPUT_21,INPUT_22, OUTPUT_2)
        );
    }

    @BeforeEach
    public void initialize(){
        findStringIndex = new FindStringIndex();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void testStrStr(String haystack, String needle, int output){
        Assertions.assertEquals(output, findStringIndex.strStr(haystack, needle));
    }

}
