package dp;

public class UglyNum_offer_49 {
    public int nthUglyNumber(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int a=0,b=0,c=0;
        for(int i = 1; i< n; i++){
            int ac = dp[a]*2;
            int bc = dp[b]*3;
            int cc = dp[c]*5;
            dp[i] = Math.min(ac, bc);
            dp[i] = Math.min(dp[i], cc);
            if(dp[i] == ac)
                a++;
            if(dp[i] == bc)
                b++;
            if(dp[i] == cc){
                c++;
            }
        }
        return dp[n-1];
    }
}
