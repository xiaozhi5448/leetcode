package GreedyStrategy;

/**
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 *
 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 *
 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 *
 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 *
 * x 是 y 的一个前缀；
 * 如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
 *
 */
public class MinString_1663 {
    private int getScore(char ch){
        return ch -'a' +1;
    }
    private char getChar(int score){
        return (char)( score + 'a' -1);
    }
    public String getSmallestString(int n, int k) {
        char[] res_chs = new char[n];
        for(int i = 0; i< n;i++){
            int tmp = k - (n-i-1)*26;
            if(tmp <= 0){
                res_chs[i] = 'a';
                k-=1;
            }else{
                res_chs[i] = getChar(tmp);
                k-= tmp;
            }
        }
        return new String(res_chs);
    }

    public String getSmallestString2(int n, int k) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < n){
            if((n-index-1)*26 >= k-1){
                sb.append('a');
                k -= 1;
            }else{
                if(k%26 == 0){
                    sb.append('z');
                    k -= 26;
                }else{
                    sb.append((char)((k%26) + 'a'-1));
                    k -= (k%26);
                }
            }
            index += 1;
        }
        return sb.toString();
    }
}
