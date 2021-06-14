package com.questions.sorting.algo.impl;

import com.questions.sorting.algo.SortingAlgo;

public class BubbleSort implements SortingAlgo {

    @Override
    public int[] sort(int[] input) {
        for (int index = input.length - 1; index >= 0; index--) {
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                if (input[innerIndex] > input[innerIndex+1]) {
                    int firstNum = input[innerIndex];
                    int secondNum = input[innerIndex+1];

                    firstNum = firstNum^secondNum;
                    secondNum = firstNum^secondNum;
                    firstNum = firstNum^secondNum;

                    input[innerIndex] = firstNum;
                    input[innerIndex+1] = secondNum;
                }
            }
        }
        return input;
    }
}
