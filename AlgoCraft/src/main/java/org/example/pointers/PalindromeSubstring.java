package org.example.pointers;

public class PalindromeSubstring {
    public static void main(String[] args) {
        String a = "mqizdjrfqtmcsruvvlhdgzfrmxgmmbguroxcbhalzggxhzwfznfkrdwsvzhieqvsrbyedqxwmnvovvnesphgddoikfwuujrhxwcrbttfbmlayrlmpromlzwzrkjkzdvdkpqtbzszrngczvgspzpfnvwuifzjdrmwfadophxscxtbavrhfkadhxrmvlmofbzqshqxazzwjextdpuszwgrxirmmlqitjjpijptmqfbggkwaolpbdglmsvlwdummsrdyjhmgrasrblpjsrpkkgknsucsshjuxunqiouzrdwwooxclutkrujpfebjpoodvhknayilcxjrvnykfjhvsikjabsdnvgguoiyldshbsmsrrlwmkfmyjbbsylhrusubcglaemnurpuvlyyknbqelmkkyamrcmjbncpafchacckhymtasylyfjuribqxsekbjkgzrvzjmjkquxfwopsbjudggnfbuyyfizefgxamocxjgkwxidkgursrcsjwwyeiymoafgyjlhtcdkgrikzzlenqgtdukivvdsalepyvehaklejxxmmoycrtsvzugudwirgywvsxqapxyjedbdhvkkvrxxsgifcldkspgdnjnnzfalaslwqfylmzvbxuscatomnmgarkvuccblpoktlpnazyeazhfucmfpalbujhzbykdgcirnqivdwxnnuznrwdjslwdwgpvjehqcbtjljnxsebtqujhmteknbinrloregnphwhnfidfsqdtaexencwzszlpmxjicoduejjomqzsmrgdgvlrfcrbyfutidkryspmoyzlgfltclmhaeebfbunrwqytzhuxghxkfwtjrfyxavcjwnvbaydjnarrhiyjavlmfsstewtxrcifcllnugldnfyswnsewqwnvbgtatccfeqyjgqbnufwttaokibyrldhoniwqsflvlwnjmffoirzmoxqxunkuepj";
        //babad
        //aacabdkacaa
        //a
        //cbbd
        //ac
        System.out.println(longestPalindrome(a));
    }

    public static String longestPalindrome(String s){
        if(s.length() == 1){
            return s;
        }
        int maxLength = 0;
        String longestPalindrome="";
        for(int i=0; i<s.length(); i++){
            // Early exit if no longer palindrome possible
            if (i + maxLength >= s.length()) {
                break;
            }
            for(int j=s.length(); j>i+maxLength; j--){
                String subString = s.substring(i,j);
                if(isPalindrome(subString)){
                    if(subString.length() > maxLength){
                        maxLength = subString.length();
                        longestPalindrome = subString;
                    }
                    break;
                }
            }
        }
        return longestPalindrome;
    }

    public static boolean isPalindrome(String substring){
        int leftIndex = 0;
        int rightIndex = substring.length()-1;
        while (leftIndex < rightIndex){
            if(substring.charAt(leftIndex) == substring.charAt(rightIndex)){
                leftIndex++;
                rightIndex--;
            }else{
                return false;
            }
        }
        return true;
    }
}
