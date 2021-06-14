package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SearchInsertPositionTest {

    private static final int[] INPUT_1 = {1,3,5,6};
    private static final int TARGET_1 = 5;
    private static final int OUTPUT_1 = 2;
    private static final int[] INPUT_2 = {1,3,5,6};
    private static final int TARGET_2 = 2;
    private static final int OUTPUT_2 = 1;
    private static final int[] INPUT_3 = {1,3,5,6};
    private static final int TARGET_3 = 7;
    private static final int OUTPUT_3 = 4;
    private SearchInsertPosition searchInsertPosition;

    public static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(INPUT_1, TARGET_1, OUTPUT_1),
                Arguments.of(INPUT_2, TARGET_2, OUTPUT_2),
                Arguments.of(INPUT_3, TARGET_3, OUTPUT_3)
        );
    }

    @BeforeEach
    private void initialize() {
        searchInsertPosition = new SearchInsertPosition();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testSearchinsert(int[] input, int target, int output) {
        Assertions.assertEquals(output, searchInsertPosition.searchInsert(input, target));
    }
}
