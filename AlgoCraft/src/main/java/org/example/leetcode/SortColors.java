package org.example.leetcode;

//https://leetcode.com/problems/sort-colors/?envType=problem-list-v2&envId=two-pointers
public class SortColors {

    public static void main(String[] args) {
        // {2,0,2,1,1,0}
        // {2,0,1}
        int [] numbers = {2,0,2,1,1,0};
        solution(numbers);
    }

    public static void solution(int[] nums) {
        int low = 0;
        int current = 0;
        int high = nums.length-1;

        while(current <= high){
            if(nums[current] == 0){
                if(current != low) {
                    int temp = nums[low];
                    nums[low] = nums[current];
                    nums[current] = temp;
                }
                low++;
                current++;
            } else if (nums[current] == 1) {
                current++;
            }
            else{
                int temp = nums[high];
                nums[high] = nums[current];
                nums[current] = temp;
                high--;
            }
        }
    }
}
