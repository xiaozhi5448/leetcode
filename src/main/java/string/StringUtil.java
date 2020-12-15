package string;

public class StringUtil {
    public int strStr_brute(String haystack, String needle){
        if(haystack.length() < needle.length()){
            return -1;
        }else{
            for(int i = 0; i< haystack.length(); i++){
                if(haystack.substring(i, i + needle.length()).compareTo(needle) == 0){
                    return i;
                }
            }
            return -1;
        }
    }

    public int strStr_kmp(String haystack, String needle){
        if(haystack.length() < needle.length()){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }else if(needle.length() == 1){
            return strStr_brute(haystack, needle);
        }
        int next[] = new int[needle.length() + 1];
        next[1] = 0;
        int count = 0;
        String partial;
        for(int i = 2; i < needle.length(); i++){
            int len = i;
            count = 0;
            partial = needle.substring(0, i);
            for(int j = 1; j < len; j++){
                if(!partial.substring(0, j).equals(partial.substring(len - j, len))){
                    break;
                }
                count++;
            }
            next[i] = count;
        }
        int res = -1;
        for(int i = 0, j = 0; i< haystack.length() && j < needle.length();i++){
            if(needle.charAt(j) == haystack.charAt(i)){
                j++;

                if(j == needle.length()){
                    res = i - needle.length() + 1;
                }
            }else{
                j = next[j];
                while(true){
                    if(needle.charAt(j) == haystack.charAt(i)){
                        j++;
                        break;
                    }
                    if(j == 0){
                        break;
                    }
                    j = next[j];
                }
            }

        }
        return res;

    }
}
