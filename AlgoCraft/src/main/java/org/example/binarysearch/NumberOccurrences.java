package org.example.binarysearch;

import java.util.Arrays;

/*
Given an array of integers sorted in non-decreasing order, return the first and last indexes
of a target number. If the target is not found. return [ -1, -1].

Example 1:
Input nums = [1, 2, 3, ~, 4, ~, S, 6, 7, 8, 9, 10, 11), target = 4
Output. [3, 5]

Explanation: The first and last occurrences of number 4 are indexes 3 and 5, respectively

*/

public class NumberOccurrences {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(getOccurrences(numbers, 4)));
    }

    private static int[] getOccurrences(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }

        int firstOccurrence = findFirstOccurrence(numbers, target);

        // If not found, no need to search for last
        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        }

        int lastOccurrence = findLastOccurrence(numbers, target);

        return new int[]{firstOccurrence, lastOccurrence};
    }

    private static int findFirstOccurrence(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return firstOccurrence;
    }

    private static int findLastOccurrence(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return lastOccurrence;
    }
}
