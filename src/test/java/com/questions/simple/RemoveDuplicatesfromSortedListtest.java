package com.questions.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class RemoveDuplicatesfromSortedListtest {

    private static RemoveDuplicatesfromSortedList removeDuplicatesfromSortedList;
    private static RemoveDuplicatesfromSortedList.ListNode headNode;
    private static RemoveDuplicatesfromSortedList.ListNode prevNode;

    public static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(createListNodeFromList(List.of(1,1,2)), createListNodeFromList(List.of(1,2))),
                Arguments.of(createListNodeFromList(List.of(1,1,2,3,3)), createListNodeFromList(List.of(1,2,3)))
        );
    }

    private static RemoveDuplicatesfromSortedList.ListNode createListNodeFromList(List<Integer> list){
        headNode = removeDuplicatesfromSortedList.new ListNode(list.get(0));
        prevNode = headNode;
        list.stream().forEach(num -> {
            RemoveDuplicatesfromSortedList.ListNode node = removeDuplicatesfromSortedList.new ListNode(num);
            prevNode.next = node;
            prevNode = node;
        });
        return headNode;
    }

    @BeforeEach
    private void setUp(){
        removeDuplicatesfromSortedList = new RemoveDuplicatesfromSortedList();
    }
}
