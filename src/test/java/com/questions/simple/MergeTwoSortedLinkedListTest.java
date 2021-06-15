package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static com.questions.simple.MergeTwoSortedLinkedList.ListNode;

public class MergeTwoSortedLinkedListTest {
    private static ListNode headNode;
    private static ListNode prevNode;
    private MergeTwoSortedLinkedList obj;

    public static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(createListNodeFromList(List.of(1, 2, 4)), createListNodeFromList(List.of(1, 3, 4)),  createListNodeFromList(List.of(1, 1, 2, 3, 4, 4))),
                Arguments.of(createListNodeFromList(Collections.EMPTY_LIST), createListNodeFromList(List.of(0)),  createListNodeFromList(List.of(0))),
                Arguments.of(createListNodeFromList(Collections.EMPTY_LIST), createListNodeFromList(Collections.EMPTY_LIST),  createListNodeFromList(Collections.EMPTY_LIST))
        );
    }

    private static ListNode createListNodeFromList(List<Integer> list) {
        if(list.isEmpty()){
            return null;
        }
        headNode = new ListNode(list.get(0));
        prevNode = headNode;
        list.stream().skip(1).forEach(num -> {
            ListNode node = new ListNode(num);
            prevNode.next = node;
            prevNode = node;
        });
        return headNode;
    }

    @BeforeEach
    private void initialize() {
        obj = new MergeTwoSortedLinkedList();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testMergeTwoList(ListNode input1, ListNode input2, ListNode output) {
        ListNode result = obj.mergeTwoLists(input1, input2);

        while(result!=null && output!=null){
            Assertions.assertEquals(output.val, result.val);
            output = output.next;
            result = result.next;
        }
    }
}
