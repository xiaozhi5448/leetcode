package string;

public class FindSubStr_28 {

    long MAX_HASH = (long)Math.pow(2, 31);
    int base = 26;
    // hash
    public long hash(char[] chs, int start, int end){
        long pivot = 1;
        long res = 0;
        for(int i = end; i >= start; i--){
            res += pivot*(chs[i]-'a');
            pivot *= base;
            res %= MAX_HASH;
        }
        return res;
    }
    private int strWithHash(String haystack, String needle){
        long hash2 = hash(needle.toCharArray(), 0, needle.length()-1);
        long hash1 = hash(haystack.toCharArray(), 0, needle.length()-1);
        long highPivot = (long)Math.pow(base, needle.length()-1);
        for(int index = 0; index + needle.length() <= haystack.length(); index++){
            if(hash1 == hash2){
                return index;
            }
            if(index + needle.length() == haystack.length()){
                break;
            }
            hash1 -= ((haystack.charAt(index) -'a')*highPivot % MAX_HASH);
            hash1 *= base;
            hash1 += (haystack.charAt(index+needle.length()) - 'a');
            hash1 %= MAX_HASH;
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        return strWithHash(haystack, needle);
    }

    //sunday

    private int strWithSunday(String haystack, String needle){
        return 0;
    }

    // kmp

    int[] calNext(String needle){
        int[] res = new int[needle.length()+1];
        res[0] = -1;
        for(int length = 2; length < needle.length(); length++){
            int prevLen = length-1;
            while(true){
                if(needle.charAt(length) == needle.charAt(res[prevLen])){
                    res[length] = res[prevLen] + 1;
                    break;
                }else{
                    prevLen = res[prevLen];
                    if(res[prevLen] == -1){
                        res[length] = 0;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
