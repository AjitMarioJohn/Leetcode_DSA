package com.questions.sorting.algo.impl;

import com.questions.sorting.algo.SortingAlgo;

public class SelectionSort implements SortingAlgo {
    @Override
    public int[] sort(int[] input) {
        for (int index = input.length - 1; index >= 0; index--) {
            int largestNumIndex = 0;
            for (int innerIndex = 0; innerIndex <= index; innerIndex++) {
                if (input[innerIndex] > input[largestNumIndex]) {
                    largestNumIndex = innerIndex;
                }
            }
            swapIndexes(input, index, largestNumIndex);
        }
        return input;
    }
}
