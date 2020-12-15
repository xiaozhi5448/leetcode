package GreedyStrategy;

public class MonotoneIncreasingDigit_738 {
    public int monotoneIncreasingDigits(int N) {
        String strN = Integer.toString(N);
        int index0 = 0;
        for(; index0 < strN.length(); index0++){
            if(index0 + 1 < strN.length() && strN.charAt(index0) > strN.charAt(index0+ 1)){
                break;
            }
        }
        if(index0 == strN.length()){
            return N;
        }else{
            while(index0 > 0){
                if(strN.charAt(index0) == strN.charAt(index0 - 1)){
                    index0--;
                }else{
                    break;
                }
            }

        }
        String finalstr = strN.substring(0, index0);
        int cur = strN.charAt(index0) - '1';
        StringBuilder sb = new StringBuilder(finalstr);
        sb.append(cur);
        for(int i = 0; i < strN.length() - index0 -1; i ++){
            sb.append('9');
        }

        return Integer.parseInt(sb.toString());

    }
}
