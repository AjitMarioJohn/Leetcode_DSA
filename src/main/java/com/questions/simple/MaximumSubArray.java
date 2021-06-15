/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23


Constraints:

1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
package com.questions.simple;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public class MaximumSubArray {
//    O(n^2) solution
    private Function<int[], Integer> bruteForce1 = (arr) -> {
        int length = arr.length;
        if(length < 1){
            return 0;
        }

        int maxSum = arr[0];
        for(int index = 0; index< length; index++){
            int curSum = 0;
            for(int innerIndex = index; innerIndex < length; innerIndex++){
                curSum+=arr[innerIndex];
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    };
    // O(n) solution
    private Function<int[], Integer> bruteForce2 = (arr) -> {
        int length = arr.length;
        if(length < 1){
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = arr[0];
        for(int index = 1; index< length; index++){
            int sum = (dp[index-1]+arr[index]);
            dp[index] = Math.max(sum, arr[index]);
        }
        return Arrays.stream(dp).max().orElse(0);
    };

    public int maxSubArray(int[] input) {
        return Optional.ofNullable(input).map(bruteForce2).orElse(0);
    }
 }
