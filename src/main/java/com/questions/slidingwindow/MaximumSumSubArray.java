package com.questions.slidingwindow;

/**
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSumSubArray {

    public int getMaximumSumOfSubArray(int[] input, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentRunningSum = 0;
        for (int firstIndex = 0; firstIndex < input.length; firstIndex++) {
            currentRunningSum += input[firstIndex];
            if (firstIndex >= k-1) {
                maxSum = Math.max(maxSum, currentRunningSum);
                currentRunningSum -= input[(firstIndex-(k-1))];
            }
        }
        return maxSum;
    }
}
