package org.example.hashmapsandsets;

import java.util.*;

/*
Given an array of integers, return the indexes of any two numbers that add up to a target
The order of the indexes in the result doesn't matter. If no pair is found, return an empty
array.
Example:
  Input: nums = [-1, 3, 4, 2], target• 3
  Output: [0, 2]

Explanation: nums[0] + nums[2] = -1 + 4 • 3
Constraints:
• The same index cannot be used twice in the result
*
*/
public class PairSum {
    public static void main(String[] args) {
        //{-1, 3, 4, 2 }, target=3
        int[] numbers = {-1, 3, 4, 2 };
        findPairSum(numbers, 10);
    }

    public static int[] findPairSum(int[] numbers, int target){
        //elements hash map is used to store numbers with index values
        //Since any two numbers is applicable, hashmap is fine for this task
        //otherwise, since hashmap keys are unique, another method need to be used.
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> elements = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            elements.put(numbers[i], i);
            int compliment = target - numbers[i];
            Integer complimentIndex = elements.get(compliment);
            if(complimentIndex != null){
                return new int[]{complimentIndex, i};
            }
        }
        return new int[0];
    }
}
