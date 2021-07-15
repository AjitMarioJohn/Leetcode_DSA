package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SqrtTest {

    private SquareRoot squareRoot;

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(8, 2),
                Arguments.of(1, 1),
                Arguments.of(2147395599, 46339)
        );
    }

    @BeforeEach
    private void initialize() {
        squareRoot = new SquareRoot();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testMySqrt(int input, int output){
        Assertions.assertEquals(output, squareRoot.mySqrt(input));
    }

}
