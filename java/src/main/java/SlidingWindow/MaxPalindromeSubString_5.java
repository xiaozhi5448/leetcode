package SlidingWindow;

public class MaxPalindromeSubString_5 {
    int length=0;
    String palindrome = "";
    public boolean isPalindrome(String s){
        int total = s.length();
        int len = s.length() / 2;
        for(int i = 0; i< len; i++){
            if(s.charAt(i) != s.charAt(total - i - 1)){
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        for(int begin = 0; begin < s.length(); begin++){
            for(int end = begin + 1; end <= s.length(); end++){
                if(isPalindrome(s.substring(begin, end))){
                    if(end - begin > length){
                        length = end - begin;
                        palindrome = s.substring(begin, end);
                    }
                }
            }
        }
        return palindrome;
    }
}
