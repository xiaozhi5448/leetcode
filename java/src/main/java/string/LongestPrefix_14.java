package string;

public class LongestPrefix_14 {
    public String prefix(String str1, String str2){
        int min_length = str1.length() < str2.length()? str1.length(): str2.length();
        int len = min_length;
        for(int i = 0; i < min_length; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                len = i;
                break;
            }
        }
        return str1.substring(0, len);
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1){
            return "";
        }
        String common = strs[0];
        for(int i = 1; i< strs.length; i++){
            common = prefix(common, strs[i]);
        }
        return common;
    }
}
