package com.questions.sorting.algo.impl;

import com.questions.sorting.algo.SortingAlgo;

public class InsertionSort implements SortingAlgo {
    @Override
    public int[] sort(int[] input) {
        for(int index=1; index < input.length; index++){
            int newElement = input[index];
            int innerIndex = index - 1;
            while((innerIndex > -1) && (input[innerIndex] > newElement)){
                input[innerIndex+1] = input[innerIndex];
                innerIndex--;
            }
            input[innerIndex+1] = newElement;
        }
        return input;
    }
}
