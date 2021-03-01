package dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 动态规划：一个数字可以自己组成字符，可以和前一个数字组成字符，但前提是组成的数字范围在10-25之间
 */
public class offer_46 {
    public int translateNum(int num) {
        String strval = String.valueOf(num);
        char[] chs = strval.toCharArray();
        int[] dp = new int[chs.length];
        dp[0] = 1;
        for(int i = 1; i< chs.length;i++){
            int val = Integer.valueOf(strval.substring(i-1, i+1));
            if(val >= 10 && val <= 25){
                if(i-2<0){
                    dp[i] = dp[i-1] + 1;
                }else{
                    dp[i] = dp[i-1]+dp[i-2];
                }
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[chs.length-1];
    }
}
