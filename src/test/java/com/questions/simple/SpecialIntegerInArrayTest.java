package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SpecialIntegerInArrayTest {

    private SpecialIntegerInArray testObj;

    @BeforeEach
    private void initialize(){
        testObj = new SpecialIntegerInArray();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testNumberOfSpecialInteger(String[] arr, int output){
        Assertions.assertEquals(output, testObj.numberOfSpecialInteger(arr));
    }

    private static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(new String[]{"121", "22", "123"}, 2),
                Arguments.of(new String[]{"13", "123", "11"}, 0)
        );
    }
}
