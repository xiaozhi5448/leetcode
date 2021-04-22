package dp;

public class DecodeMethodCount_91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int [] dp = new int[s.length() + 1];
        dp[0] = 1;dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            int num = Integer.parseInt(s.substring(i-2, i));
            String neighbours = s.substring(i-2, Math.min(i+1, s.length()));
            if(s.charAt(i-1) == '0'){
                if(num > 26 || num < 1)
                    return 0;
            }
            if(neighbours.contains("0")){
                dp[i] = dp[i-1];
                continue;
            }
            if(num >= 1 && num <= 26){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
