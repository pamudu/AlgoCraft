package org.example.slidingwindow;
/*
 Given two strings, s and t, both consisting of lowercase English letters, return the number
 of substrings in s that are anagrams oft.
 An anagram is a word or phrase formed by rearranging the letters of another word or
 phrase, using all the original letters exactly once.
 Example:
  Inputs = "caabab", t = "aba"
  Output: 2

 Explanation: There is an anagram oft starting at index 1 ("caabab") and another starting at
index 2 ("aba")
* */
public class SubstringAnagrams {
    public static void main(String[] args) {
        System.out.println(getNumberOfAnagrams("abcxyzcba","abc"));
    }

    public static int getNumberOfAnagrams(String text, String anagram){
        if(text == null || text.length() < anagram.length()){
            return 0;
        }
        int left = 0;
        int right = 0;
        int fixedLength = anagram.length();
        int numberOfAnagrams = 0;
        while(right <= text.length()){
            if(right - left == fixedLength){
                if(isAnagram(text.substring(left,right),anagram)){
                    numberOfAnagrams++;
                }
                left++;
            }
            right++;
        }
        return numberOfAnagrams;
    }

    private static boolean isAnagram(String subString, String anagram) {
        int [] charCount = new int[256]; //ASCII character set
        for(int i=0; i < subString.length(); i++){
            charCount[subString.charAt(i)]++;
            charCount[anagram.charAt(i)]--;
        }
        for(int count : charCount){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
