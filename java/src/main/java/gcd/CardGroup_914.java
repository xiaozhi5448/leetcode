package gcd;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class CardGroup_914 {
    int min;
    int max;
    private int gcd(int x, int y){
        if(x == 0){
            return y;
        }else{
            min = x >y? y:x;
            max = x>y? x:y;
            return gcd(max%min, min);
        }
    }

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer num:deck){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        Collection<Integer> counts = map.values();
        int g = -1;
        for(Integer count:counts){
            if (g==-1){
                g = count;
            }else{
                g = gcd(g, count);
            }
        }
        return g>=2;
    }

}
