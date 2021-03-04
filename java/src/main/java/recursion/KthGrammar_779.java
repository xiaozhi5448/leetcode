package recursion;

import java.util.BitSet;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 */
public class KthGrammar_779 {
    //模拟每一行的生成过程，使用bitset模拟
    BitSet bits = new BitSet();
    private void recursionUtil(int N) {
        if (N == 2) {
            bits.set(1, !bits.get(0));
        } else {
            recursionUtil(N - 1);
            int len = (int)Math.pow(2, N -1);
            int prevLen = len/2;
            for(int i = 0; i < prevLen; i++){
                bits.set(i + prevLen, !bits.get(i));
            }
        }
    }
    private int loopUtil(int N, int K){
        bits.clear();
        for(int i = 1; i< N; i++){
            int len = (int)Math.pow(2, i);
            int prev_len = len /2;
            for(int j=0;j<prev_len; j++){
                bits.set(j + prev_len, !bits.get(j));
            }
        }
        if(bits.get(K-1)){
            return 1;
        }else{
            return 0;
        }
    }

    public int kthGrammar(int N, int K) {
        return loopUtil(N, K);
    }

    // recursion

    /**
     * 第N行第K个数由第N-1行第（N+1）/2 生成
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar2(int N, int K){
        if(N == 0){
            return 0;
        }else{
            int generator = kthGrammar2(N-1, (K+1)/2);
            if(generator == 0){
                return 1-K%2;
            }else{
                return K%2;
            }
        }
    }
}
