package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveDuplicateFromSortedArrayTest {

    private RemoveDuplicateFromSortedArray removeDuplicateObj;

    private static Stream<Arguments> inputSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5),
                Arguments.of(new int[]{0, 1,2,3,4,5}, 6)
        );
    }

    @BeforeEach
    private void initialize() {
        removeDuplicateObj = new RemoveDuplicateFromSortedArray();
    }

    @ParameterizedTest
    @MethodSource(value = "inputSource")
    public void testRemoveDuplicate(int[] input, int output) {
        Assertions.assertEquals(output, removeDuplicateObj.removeDuplicates(input));
    }
}
