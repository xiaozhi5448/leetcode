package bit;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 核心：对任意正整数 i， i&(i-1)可以将i二进制位最后一个1变为0
 * 解法：最高有效位+动态规划
 * bits[i] = bits[i-maxEff]+1;
 */
public class BitCount_338 {
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        bits[0]  = 0;
        int maxEff = 0;
        for(int i = 1; i<= num; i++){
            if((i&(i-1))==0){
                maxEff = i;
            }
            bits[i] = bits[i-maxEff]+1;
        }
        return bits;
    }
}
