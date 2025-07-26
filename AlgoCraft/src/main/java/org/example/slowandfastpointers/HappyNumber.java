package org.example.slowandfastpointers;
/*
In number theory, a happy number is defined as a number that, when repeatedly sµbjected
to the process of squaring its digits and summing those squares, eventually leads to 1.

An unhappy number will never reach 1 during this process, and will get stuck in an infinite
loop.
Given an integer, determine if it's a happy number.
Example,
Input: n = 23
       Output. True .
       Explanation: 2^2 + 3^2 = 13 =>>> 1^2 + 3^2 =10 =>>> 1^2 + 0^2 =1

*/
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappyNumber(116));
    }

    public static boolean isHappyNumber(int number){
        int slowPointer = getNextNumber(number);
        int fastPointer = getNextNumber(getNextNumber(number));

        while(true){
            slowPointer = getNextNumber(slowPointer);
            fastPointer = getNextNumber(getNextNumber(fastPointer));
            if(slowPointer == fastPointer){
                return false;
            }
            if(fastPointer == 1){
                return true;
            }
        }
    }

    public static int getNextNumber(int number){
        int total = 0;
        int temp = number;
        while(temp != 0){
            int remainder = temp % 10;
            total += (int) Math.pow(remainder, 2);
            temp = temp / 10;
        }
        return total;
    }
}
