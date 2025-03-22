package org.example.pointers;

import java.util.regex.Pattern;

/*
A palindrome Is a sequence of characters that reads the same forward and backward.
Given a string. determine if it's a palindrome after removing all non-alphanumeric characters.
A character is alphanumeric if it's either a letter or a number.
Example 1:
    Inputs = "a dog I a panic in a pagoda."
    Output True

Constraints:
The string may include a combination of lowercase English letters, numbers, spaces, and
punctuations.
* */
public class IsPalindromeValid {
    public static void main(String[] args) {
        // abc123
        // racecar
        // a dog! a panic in a pagoda.
        System.out.println(isPalindrome("I am AI"));
    }

    public static boolean isPalindrome(String word){
        word = word.toLowerCase();

        int leftPointer = 0;
        int rightPointer = word.length()-1;

        while(leftPointer < rightPointer){

            while(leftPointer < rightPointer && !isAlphanumeric(word.charAt(leftPointer))) {
                leftPointer++;
            }

            while(leftPointer < rightPointer && !isAlphanumeric(word.charAt(rightPointer))) {
                rightPointer--;
            }

            if(word.charAt(leftPointer) == word.charAt(rightPointer)){
                leftPointer++;
                rightPointer--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(char c){
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
        return pattern.matcher(String.valueOf(c)).find();
    }
}
