package dp;

public class MinCostClimb_746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length ==1){
            return cost[0];
        }
        int dp[] = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] =cost[1];
        for(int i = 2;i < cost.length; i++){
            dp[i] = Math.min(dp[i-2], dp[i-1] ) + cost[i];
        }
        dp[dp.length-1] = Math.min(dp[dp.length-2], dp[dp.length-3]);
        return dp[cost.length];
    }
}
