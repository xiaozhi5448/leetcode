package GreedyStrategy;

import java.util.Arrays;

public class DilverCookie_455 {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        boolean[] dilvered = new boolean[s.length];
        Arrays.sort(s);
        Arrays.sort(g);
        for(int i = 0; i<g.length;i++){
            for(int j = 0; j < s.length;j++){
                if(!dilvered[j]){
                    if(s[j] >= g[i]){
                        dilvered[j] = true;
                        res++;
                        break;
                    }
                }
            }
        }
        return res;

    }
}
