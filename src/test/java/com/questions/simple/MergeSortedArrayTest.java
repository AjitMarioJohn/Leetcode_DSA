package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeSortedArrayTest {

    private MergeSortedArray obj;

    @BeforeEach
    private void initialize(){
        obj = new MergeSortedArray();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testMerge(int[] input1, int input_1_length, int[] input2, int input_2_length, int[] output){
        obj.merge(input1, input_1_length, input2, input_2_length);
        Assertions.assertArrayEquals(output, input1);
    }
    private static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2,5,6}, 3, new int[]{1,2,2,3,5,6}),
                Arguments.of(new int[]{1}, 1, new int[]{}, 0, new int[]{1})
        );
    }

}
