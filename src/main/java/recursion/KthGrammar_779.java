package recursion;

import java.util.BitSet;

public class KthGrammar_779 {
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
//        bits.clear();
//        if (N == 1 && K == 1) {
//            return 0;
//        }
//        recursionUtil(N);
//        if (bits.get(K - 1)) {
//            return 1;
//        } else {
//            return 0;
//        }
        return loopUtil(N, K);

    }
}
