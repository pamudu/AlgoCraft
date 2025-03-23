package org.example.pointers;

/*
You are given an array of numbers, each representing the height of a vertical line on a graph,
A container can be formed with any pair of these lines, along with the x-axis o'f the graph,
Return the amount of water which the largest container can hold.

Input heights = [2, 7, 8, 3, 7, 6]
Output: 24

 */
public class LargestContainer {
    public static void main(String[] args) {
        // {2, 7, 8, 3, 7, 6}
        // {}
        // {1}
        // {1, 0, 1}
        // {3, 3, 3, 3}
        // {1, 2, 3}
        // {3, 2, 1}
        int[] heights = {2, 7, 8, 3, 7, 6};
        System.out.println(findMaxWater(heights));
    }

    public static int findMaxWater(int [] heights){

        if (heights == null || heights.length < 2) {
            return 0;
        }

        int leftPointer = 0;
        int rightPointer = heights.length-1;
        int maxWater = 0;
        int water = 0;
        while(leftPointer < rightPointer){

            if(heights[leftPointer] < heights[rightPointer]){
                water = heights[leftPointer] * (rightPointer - leftPointer);
                maxWater = Math.max(maxWater, water);
                leftPointer++;
            } else if (heights[leftPointer] > heights[rightPointer]) {
                water = heights[rightPointer] * (rightPointer - leftPointer);
                maxWater = Math.max(maxWater, water);
                rightPointer--;
            }else{
                water = heights[rightPointer] * (rightPointer - leftPointer);
                maxWater = Math.max(maxWater, water);
                leftPointer++;
                rightPointer--;
            }
        }
        return maxWater;
    }
}
