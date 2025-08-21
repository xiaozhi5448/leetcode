package interview.didi;

public class Solution {
    public int numConvert(String input){
        long val = 0;
        if(input == null || input.isEmpty()){
            return 0;
        }
        char[] charArray = input.toCharArray();
        int lowerBound = '0';
        int upperBound = '9';
        for (char c : charArray) {
            if (c >= lowerBound && c <= upperBound) {
                val = val * 10 + c - '0';
                if(val > Integer.MAX_VALUE){
                    throw new IllegalArgumentException("值超出int范围限制");
                }
            } else {
                throw new IllegalArgumentException("非法的十进制字符串");
            }
        }
        return (int)val;
    }
}
