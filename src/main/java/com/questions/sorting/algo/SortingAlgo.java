package com.questions.sorting.algo;

public interface SortingAlgo {

    int[] sort(int[] input);

    default void swapIndexes(int[] input, int lowIndex, int highIndex){
        int firstNum = input[lowIndex];
        int secondNum = input[highIndex];

        firstNum = firstNum^secondNum;
        secondNum = firstNum^secondNum;
        firstNum = firstNum^secondNum;

        input[lowIndex] = firstNum;
        input[highIndex] = secondNum;
    }
}
