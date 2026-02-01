package org.example.stack;

import java.util.Stack;

public class NextLargestNumber {

    public static void main(String[] args) {
        int [] numbers = {1,1,2,3,2,3,2,4};
        var result = nextLargestNumberToRight(numbers);
        for(int i : result){
            System.out.println(i);
        }
    }

    public static int[] nextLargestNumberToRight(int [] numbers){
        Stack<Integer> candidate = new Stack<>();
        int[] result = new int[numbers.length];
        for(int i = numbers.length-1; i >=0; i--){
            while(!candidate.empty() && numbers[i] >= candidate.peek()){
                candidate.pop();
            }
            candidate.push(numbers[i]);

            result[i] = candidate.size() >= 2 ? candidate.get(candidate.size() -2) : -1;
        }

        return result;
    }
}
