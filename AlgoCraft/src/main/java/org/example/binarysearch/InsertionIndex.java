package org.example.binarysearch;

/*
You are given a sorted array that contains unique values, along with an integer target
• If the array contains the target value, return its index.
• Otherwise, return the insertion index. This is the index where the target would be if it
were inserted in order, maintaining the sorted sequence of the array.

Example 1:
    Input: nums = [1, 2, 4, 5, 7, 8, 9], target= 4
    Output: 2
Example 2:
    Input: nums = [1, 2, 4, 5, 7, 8, 9], target = 6
    Output: 4
    Explanation: 6 would be inserted at index 4 to be positioned between 5 and 7:
    [1, 2, 4,5, 6, 7, 8, 9].
*/
public class InsertionIndex {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5, 7, 8, 9};
        System.out.println(findInsertionIndex(numbers, 6));
    }

    public static int findInsertionIndex(int [] numbers, int target){
        if(numbers == null || numbers.length == 0){
            return 0;
        }
        int left = 0;
        int right = numbers.length;
        while(left < right){
            int mid = (left+right)/2;
            if(numbers[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
