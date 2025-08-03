package org.example.slidingwindow;

import java.util.HashSet;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithUniqueChars("abcba"));
    }

    public static int longestSubstringWithUniqueChars(String word){
        if(word == null || word.isEmpty()){
            return 0;
        }
        if(word.length() == 1){
            return 1;
        }
        int maxLength = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        HashSet<Character> letters = new HashSet<>();
        while(rightPointer < word.length()){
            char newLetter = word.charAt(rightPointer);
            if(!letters.contains(newLetter)){
                letters.add(newLetter);
                rightPointer++;
            }else{
                letters.remove(word.charAt(leftPointer));
                leftPointer++;
            }
            maxLength = Math.max(maxLength, (rightPointer-leftPointer));
        }
        return maxLength;
    }
}
