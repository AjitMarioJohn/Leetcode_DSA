package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoSortedLinkedListTest {
    private MergeTwoSortedLinkedList obj;

    private static Stream<Arguments> inputSource(){
        return Stream.of(Arguments.of(new LinkedList<>(List.of(1, 2, 4)),
                new LinkedList<>(List.of(1,3,4)),
                new LinkedList<>(List.of(1,1,2,3,4,4))),
                Arguments.of(new LinkedList<>(),
                        new LinkedList<Integer>(),
                        new LinkedList<Integer>()),
                Arguments.of(new LinkedList<>(),
                        new LinkedList<>(List.of(0)),
                        new LinkedList<>(List.of(0))),
                Arguments.of(new LinkedList<>(List.of(0)),
                        new LinkedList<Integer>(),
                        new LinkedList<>(List.of(0))));
    }

    @BeforeEach
    private void initialize(){
        obj = new MergeTwoSortedLinkedList();
    }

    @ParameterizedTest
    @MethodSource(value = "inputSource")
    public void testMergeTwoList(LinkedList<Integer> input_1, LinkedList<Integer> input_2, LinkedList<Integer> output){
        Assertions.assertEquals(output, obj.mergeTwoList(input_1, input_2));
    }
}
