package GreedyStrategy;

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
}
