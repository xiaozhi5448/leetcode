package gcd;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * gcd： 最大公约数
 */
public class CardGroup_914 {
    private int gcd(int x, int y){
        return x == 0 ? y: gcd(y%x, x);
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
        Optional<Integer> reduced = counts.stream().reduce((Integer num1, Integer num2)->gcd(num1
                , num2));
        int res = reduced.get();
        return res >= 2;
//        int g = -1;
//        for(Integer count:counts){
//            if (g==-1){
//                g = count;
//            }else{
//                g = gcd(g, count);
//            }
//        }
//        return g>=2;
    }

}
