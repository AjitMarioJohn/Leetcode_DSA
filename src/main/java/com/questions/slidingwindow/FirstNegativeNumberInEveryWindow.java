package com.questions.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
 *
 *
 *
 * Example 1:
 *
 * Input :
 * N = 5
 * A[] = {-8, 2, 3, -6, 10}
 * K = 2
 * Output :
 * -8 0 -6 -6
 * Explanation :
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 *
 * Example 2:
 * Input :
 * N = 8
 * A[] = {12, -1, -7, 8, -15, 30, 16, 28}
 * K = 3
 * Output :
 * -1 -1 -7 -15 -15 0
 *
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an integer K as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative integer , then return 0 for that window.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(K)
 *
 * Constraints:
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 * 1 <= K <= N
 *
 * resource --
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * https://www.youtube.com/watch?v=CYloJQ9B4Lw
 */
public class FirstNegativeNumberInEveryWindow {
    public long[] printFirstNegativeInteger(long[] inputArr, int arrSize, int k) {
        long[] result = new long[((arrSize-k)+1)];
        int windowStart = 0;
        int index=0;
        Queue<Long> queue = new LinkedList<>();
        for (int windowEnd = 0; windowEnd < arrSize; windowEnd++) {
            if (inputArr[windowEnd] < 0) {
                queue.add(inputArr[windowEnd]);
            }
            if (((windowEnd-windowStart)+1) == k) {
                if (queue.isEmpty()) {
                    result[index++] = 0;
                }  else {
                    result[index++] = queue.peek();
                    if (inputArr[windowStart] == queue.peek()) {
                        queue.poll();
                    }
                }
                windowStart++;
            }
        }
        return result;
    }
}
/*
Brute Force
public class FirstNegativeNumberInEveryWindow {
    public long[] printFirstNegativeInteger(long[] inputArr, int arrSize, int k) {
        long[] result = new long[((arrSize-k)+1)];
        int lastArrIndex = 0;
        int windowStart = 0;
        for (int windowEnd=(k-1); windowEnd < arrSize; windowEnd++) {
            int currentRunningIndex = windowStart;
            boolean negativeNumberFound = false;
            for (int index =0 ; index < k; index++) {
                if (inputArr[currentRunningIndex] < 0) {
                    result[lastArrIndex] = inputArr[currentRunningIndex];
                    lastArrIndex++;
                    negativeNumberFound = true;
                    break;
                }
                currentRunningIndex++;
            }
            if (!negativeNumberFound) {
                result[lastArrIndex] = 0;
                lastArrIndex++;
            }
           windowStart++;
        }
        return result;
    }
}

*/
