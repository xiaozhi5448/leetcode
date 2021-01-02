package bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心思想是位运算，从低位到高位，每一位上1的个数不是三的倍数，该位在结果中是1
 */
public class SingleNumber_137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        int bit = 1;
        int cnt = 0;
        for(int i = 0; i< 32; i++){
            cnt = 0;
            int a = bit << i;
            for(Integer num :nums){
                if((num & a) != 0){
                    cnt ++;
                }
            }
            if(cnt % 3 != 0){
                res |= a;
            }
        }
        return res;
    }
    public int singleNumber2(int[] nums){
        HashMap<Integer, Integer> data = new HashMap<>();
        for(Integer num:nums){
            if(!data.containsKey(num)){
                data.put(num, 1);
            }else{
                data.put(num, data.get(num) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: data.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
