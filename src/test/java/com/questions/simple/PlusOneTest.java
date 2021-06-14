package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PlusOneTest {

    private PlusOne plusOne;

    public static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,4}),
                Arguments.of(new int[]{0}, new int[]{1}),
                Arguments.of(new int[]{9}, new int[]{1,0}),
                Arguments.of(new int[]{9,9}, new int[]{1,0,0})
        );
    }

    @BeforeEach
    private void initialize(){
        plusOne = new PlusOne();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testPlusOne(int[] input, int[] output){
        Assertions.assertArrayEquals(output, plusOne.plusOne(input));
    }

}
