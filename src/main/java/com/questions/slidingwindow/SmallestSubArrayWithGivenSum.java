package com.questions.slidingwindow;

public class SmallestSubArrayWithGivenSum {
    public int getSmalledSubArrayOfGivenSum(int[] inputArr, int targetSum) {
        int smallestArrSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < inputArr.length; windowEnd++) {
            currentWindowSum += inputArr[windowEnd];
            while (currentWindowSum >= targetSum) {
                smallestArrSize = Math.min(smallestArrSize, ((windowEnd-windowStart)+1));
                currentWindowSum -= inputArr[windowStart];
                windowStart++;
            }
        }
        return smallestArrSize;
    }
}
