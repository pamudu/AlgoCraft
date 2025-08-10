package org.example.slidingwindow;

import java.util.HashMap;
/*
A uniform substring is one in which all characters are identical. Given a string, determine the
length of the longest uniform substring that can be formed by replacing up to k characters.
Example:
a a b c d c c a -> a a [ c c c c c ] a
Input: s = "aabcdcca", k = 2
Output: 5
Explanation: if we can only replace 2 characters, the longest uniform substring we can
achieve is •ccccc", obtained by replacing b and d with c.
*/
public class LongestUniformSubstring {
    public static void main(String[] args) {
        System.out.println(findLongestUniformSubstring("aabcdcca",2));
    }

    public static int findLongestUniformSubstring(String text, int k){
        if(text == null || text.isEmpty()){
            return 0;
        }
        int leftPointer = 0;
        int rightPointer = 0;
        int longestWindowSize = 0;
        HashMap<Character, Integer>  charFrequency = new HashMap<>();
        int highestFrequency = 0;
        while(text.length() > rightPointer){
            char newChar = text.charAt(rightPointer);
            charFrequency.put(newChar, charFrequency.getOrDefault(newChar,0)+1);
            highestFrequency = Math.max(charFrequency.get(newChar), highestFrequency);
            int windowLength = (rightPointer-leftPointer) + 1;

             int numberOfCharsToReplace = windowLength - highestFrequency;

             if(k  >= numberOfCharsToReplace ){
                 rightPointer++;
                 if(longestWindowSize < windowLength){
                     longestWindowSize = windowLength;
                 }
             }else {
                 charFrequency.put(newChar, charFrequency.get(newChar)-1);
                 leftPointer++;
             }
        }
        return longestWindowSize;
    }

}
