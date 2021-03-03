package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  动态规划：投掷第i个骰子的结果和之前i-1个骰子结果有关
 */

public class DiceProbability_offer_60 {
    public double[] dicesProbability(int n) {
        // 声明dp数组
        int[][] dp = new int[n+1][6*n+1];
        for(int i = 1; i <= 6; i++){
            dp[1][i] = 1;
        }
        // 计算第i个骰子投掷后的结果
        for(int count=2; count <= n; count++){
            for(int dices = count; dices <= 6*count; dices++){
                for(int dice = 1; dice <= 6; dice++){
                    if(dices-dice>0)
                    dp[count][dices] += dp[count-1][dices-dice];
                }
            }
        }
        double total = Math.pow(6, n);
        double[] res = new double[6*n - n + 1];
        for(int i = n; i <= 6*n; i++){
            res[i-n] =  (dp[n][i] / total);
        }
        return res;
    }
}
