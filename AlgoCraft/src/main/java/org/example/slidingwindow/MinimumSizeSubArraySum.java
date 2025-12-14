package org.example.slidingwindow;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int [] numbers1 = {2,3,1,2,4,3};
        int [] numbers2 = {1,4,4};
        int [] numbers3 = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(7, numbers1));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int leftPointer = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {

            currentSum += nums[rightPointer];

            while (currentSum >= target) {

                int currentWindowLength = rightPointer - leftPointer + 1;
                minLength = Math.min(minLength, currentWindowLength);

                currentSum -= nums[leftPointer];

                leftPointer++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
