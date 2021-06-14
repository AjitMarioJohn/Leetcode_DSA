package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MaximumSubArrayTest {

    private MaximumSubArray maximumSubArray;

    public static final Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5,4,-1,7,8}, 23)
        );
    }

    @BeforeEach
    private void setUp(){
        maximumSubArray =  new MaximumSubArray();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testMaxSubArray(int[] input, int output){
        Assertions.assertEquals(output, maximumSubArray.maxSubArray(input));
    }

}
