package middle;

import java.util.ArrayList;
import java.util.List;

public class SumOfSquare {
    int sum;
    int count = 0;
    int res = Integer.MAX_VALUE;
    List<Integer> squares = new ArrayList<Integer>();
    private void find_squares(int n){
        for(int i = 1; i <= n ; i++){
            double sq = Math.sqrt(i);
            if(sq == Math.floor(sq)){
                squares.add(i);
            }

        }
    }
    private void recursionMethod(List<Integer> squares, int n){
        if(n == sum){
            if(count < res){
                res = count;
            }
            return ;
        }else if(n >sum){
//            count = -1;
            return;
        }else{
            count += 1;
            for(Integer ele: squares) {
                recursionMethod(squares, n + ele);
            }
            count -= 1;
        }

    }
    public int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        sum = n;
        find_squares(n);
        recursionMethod(squares, 0);
        return res;
    }

    public int numSquresDP(int n){
        find_squares(n);
        int dp[] = new int[n + 1];
        for(int i = 0; i < n+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i <= n ;i ++){
            if(i <= 3){
                dp[i] = i;
            }else{
                for(Integer ele: squares){
                    if(i < ele){
                        break;
                    }else{
                        dp[i] = Math.min(dp[i], dp[i - ele] + 1);
                    }
                }

            }
        }
        return dp[n];
    }


}
