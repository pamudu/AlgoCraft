package org.example.binarysearch;

import java.util.Arrays;
/*
You are given an array representing the heights of trees, and an integer k representing the
total length of wood that needs to be cut.

For this task, a woodcutting machine is set to a certain height, H. The machine cuts off the
top part of all trees taUer than H, while trees shorter than H remain untouched. Determine
the highest possible setting of the woodcutter (H) so that it cuts at least k meters of wood,
Assume the woodcutter cannot be set higher than the height of the tallest tree in the array.

Input heights = (2, 6, 3, 8], k = 7
Output: 3

Explanation: The highest possible height setting that yields at least k = 7 meters of wood is
3, which yields 8 meters of wood. Any height setting higher than this will yield less than 7
meters of wood.

Constraints:
• It's always possible to attain at least k meters of wood.
• There's at least one tree
*/

public class CuttingWood {

    public static void main(String[] args) {
        int [] heights = {2, 6, 3, 8};
        int k = 7;
        System.out.println(getWoodCutterHeight(heights, k));
    }

    private static int getWoodCutterHeight(int [] heights, int k){
        validateInputs(heights, k);

        int minHeight = 0;
        int maxHeight = Arrays.stream(heights).max().orElse(0);

        while(minHeight < maxHeight){
            int midHeight = ((minHeight + maxHeight) / 2 ) + 1;
            if(cutEnoughWood(heights, k, midHeight)){
                minHeight = midHeight; // Valid height, try higher
            }else{
                maxHeight = midHeight - 1; // Not enough wood, try lower
            }
        }
        return maxHeight;
    }

    private static boolean cutEnoughWood(int [] heights, int k, int threshold){
        int cutWood = 0;
        for(int height : heights){
            if(height > threshold){
                cutWood += (height - threshold);
            }
        }
        return k <= cutWood;
    }

    private static void validateInputs(int[] heights, int required) {
        if (heights == null || heights.length == 0) {
            throw new IllegalArgumentException("Tree heights cannot be null or empty");
        }
        if (required <= 0) {
            throw new IllegalArgumentException("Required wood must be positive");
        }
    }
}
