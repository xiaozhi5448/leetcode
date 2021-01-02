package GreedyStrategy;

public class UniqStringMinCost_1578 {
    public int minCost(String s, int[] cost) {
        char[] chs = s.toCharArray();
        int index=0;
        int len = 0;
        int res = 0;
        int cost_val = 0;
        int max_cost = 0;
        while(index < s.length()){
            len = 1;
            max_cost = 0;
            cost_val = 0;
            while(true ){
                if(index+len < s.length() && chs[index] == chs[index+len]){
                    len++;
                }else{
                    break;
                }
            }
            if(len>1){
                for(int i = 0; i < len;i++){
                    cost_val += cost[index+i];
                    if(cost[index+i] > max_cost){
                        max_cost = cost[index+i];
                    }
                }
                cost_val -= max_cost;
                res += cost_val;
            }
            index+=len;

        }
        return res;
    }
}
