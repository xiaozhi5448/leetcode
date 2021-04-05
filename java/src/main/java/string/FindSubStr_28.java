package string;

public class FindSubStr_28 {

    long MAX_HASH = (long)Math.pow(2, 31);
    int base = 128;
    // hash
    private long hash(char[] chs, int start, int end){
        int pivot = 1;
        long res = 0;
        for(int i = end; i >= start; i--){
            res += pivot*chs[i];
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
            hash1 -= haystack.charAt(index)*highPivot;
            hash1 *= base;
            hash1 += haystack.charAt(index+needle.length());
            hash1 %= MAX_HASH;
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 || haystack.length() < needle.length()){
            return -1;
        }
        return strWithHash(haystack, needle);
    }

    //sunday

    private int strWithSunday(String haystack, String needle){
        return 0;
    }
}
