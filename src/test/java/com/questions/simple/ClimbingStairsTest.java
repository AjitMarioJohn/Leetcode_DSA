package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ClimbingStairsTest {

    private ClimbingStairs climbingStairs;

    @BeforeEach
    private void initialize(){
        climbingStairs = new ClimbingStairs();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testClimbStaris(int input, int output){
        Assertions.assertEquals(output, climbingStairs.climbStairs(input));
    }

    private static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(2,2),
                Arguments.of(3,3)
        );
    }
}
