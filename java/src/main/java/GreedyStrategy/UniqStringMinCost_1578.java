package GreedyStrategy;

/**
 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 *
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 *
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
 *
 */
public class UniqStringMinCost_1578 {

    public int minCost(String s, int[] cost) {
        int index = 0;
        int maxVal = 0;
        char[] chs = s.toCharArray();
        int ret = 0;
        while(index < chs.length){
            char ch = chs[index];
            maxVal = 0;
            while(index < chs.length && chs[index] == ch){
                ret += cost[index];
                maxVal = Math.max(maxVal, cost[index]);
                index += 1;
            }
            ret -= maxVal;
        }
        return ret;
    }
}
