package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveElementTest {

    private static final int[] INPUT_11 = new int[]{3,2,2,3};
    private static final int INPUT_12 = 3;
    private static final int OUTPUT_1 = 2;
    private static final int[] INPUT_21 = new int[]{0,1,2,2,3,0,4,2};
    private static final int INPUT_22 = 2;
    private static final int OUTPUT_2 = 5;
    private RemoveElement removeElement;

    private static Stream<Arguments> inputs(){
        return Stream.of(Arguments.of(INPUT_11, INPUT_12, OUTPUT_1),
                Arguments.of(INPUT_21, INPUT_22, OUTPUT_2));
    }

    @BeforeEach
    private void initialize(){
        removeElement = new RemoveElement();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void testRemoveElement(int[] num, int val, int output){
        Assertions.assertEquals(output, removeElement.removeElement(num, val));
    }

}
