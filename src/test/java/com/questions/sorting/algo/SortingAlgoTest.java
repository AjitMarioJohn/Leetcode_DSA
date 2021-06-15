package com.questions.sorting.algo;

import com.questions.sorting.algo.impl.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SortingAlgoTest {

    private SortingAlgo sortingAlgo;

    private static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5, 1, 4, 6}, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{3, 2, -5, 1, -4, 6}, new int[]{-5,-4,1, 2, 3, 6})
        );
    }

    @BeforeEach
    private void setUp(){
        sortingAlgo = new InsertionSort();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testSortingAlgo(int[] input, int[] output){
        Assertions.assertArrayEquals(output, sortingAlgo.sort(input));
    }

}
