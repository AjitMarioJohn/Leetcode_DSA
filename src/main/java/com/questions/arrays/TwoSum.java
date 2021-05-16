package com.questions.arrays;

/*
*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return this.onePassHashTable.apply(nums, target);
    }

    private BiFunction<int[], Integer, int[]> bruteForceSolution = (nums, target) -> Optional.ofNullable(nums).map(numArr -> {
            if(numArr.length <= 2)
                return new int[]{};

            for(int index=0; index < numArr.length; index++){
                for(int secIndex = index+1; secIndex < numArr.length; secIndex++){
                    if(numArr[index]+numArr[secIndex] == target){
                        return  new int[]{index, secIndex};
                    }
                }
            }
        return null;
    }).get();

    private BiFunction<int[], Integer, int[]> twoPassHashTable = (nums, target) -> Optional.ofNullable(nums).map(numArr -> {
        if(numArr.length <= 2)
            return new int[]{};

        Map<Integer, Integer> map = new HashMap<>();
        int[] indexes = new int[]{};
        for(int index=0; index < numArr.length; index++){
            map.put(numArr[index], index);
        }
        for(int index=0; index < numArr.length; index++){
            if(map.containsKey(target-numArr[index]))
                return new int[]{index, map.get(target-numArr[index])};
        }
        return indexes;
    }).get();

    private BiFunction<int[], Integer, int[]> onePassHashTable = (nums, target) -> Optional.ofNullable(nums).map(numArr -> {
        int[] indexes = new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for(int index=0; index < numArr.length; index++){
            int complement = target-numArr[index];
            if(map.containsKey(complement))
                return new int[]{index, map.get(complement)};

            map.put(numArr[index], index);
        }
        return indexes;
    }).get();
}
