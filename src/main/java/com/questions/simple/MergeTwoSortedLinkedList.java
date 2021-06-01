/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
*/
package com.questions.simple;

import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MergeTwoSortedLinkedList {
    private final BiFunction<LinkedList<Integer>, Integer, Integer> getNumberFromIndex = (list,index) -> index < list.size() ? list.get(index) : 0;
    private final BiPredicate<Integer, Integer> isFirstCounterIncremental = (firstNum, secondNum) -> firstNum <= secondNum;
    private final BiPredicate<Integer, Integer> isCounterReachThreshold = (counter, threshold) -> counter >= threshold;
    private final BiPredicate<Integer, Integer> isSecondCounterReachedThreshold = this.isCounterReachThreshold::test;

    private final BiPredicate<Integer, Integer> isFirstCounterReachedThreshold = this.isCounterReachThreshold::test;
    private final Predicate<LinkedList<Integer>> isListEmpty = AbstractCollection::isEmpty;

    public LinkedList<Integer> mergeTwoList(LinkedList<Integer> input_1, LinkedList<Integer> input_2) {
        final LinkedList<Integer> output = new LinkedList<>();

        int firstCounter = 0;
        int secondCounter = 0;

        while(this.isFirstCounterReachedThreshold.negate().test(firstCounter, (input_1.size())) ||
            this.isSecondCounterReachedThreshold.negate().test(secondCounter, (input_2.size()))){
            int firstNum = this.getNumberFromIndex.apply(input_1, firstCounter);
            int secondNum = this.getNumberFromIndex.apply(input_2,secondCounter);

            if(this.isListEmpty.negate().test(input_1) && this.isFirstCounterIncremental.test(firstNum, secondNum)){
                output.add(firstNum);
                firstCounter++;
            }

           if(this.isListEmpty.negate().test(input_2)){
               output.add(secondNum);
               secondCounter++;
           }
        }

        return output;
    }
}
