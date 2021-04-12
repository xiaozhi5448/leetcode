package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class MaxNum_179 {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b)->{
            char[] achs = String.valueOf(a).toCharArray();
            char[] bchs = String.valueOf(b).toCharArray();
            if(achs[0] != bchs[0]){
                return String.valueOf(b).compareTo(String.valueOf(a));
            }else{
                return (String.valueOf(b)+String.valueOf(a)).compareTo((String.valueOf(a) + String.valueOf(b)));
            }
        });
        for(int num:nums){
            heap.offer(num);
        }
        StringBuilder sb = new StringBuilder();

        while(!heap.isEmpty()){
            sb.append(heap.poll().toString());
        }
        return sb.toString();
    }

    public String largestNumber2(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums).boxed().sorted((a,b)->{
            String stra = String.valueOf(a);
            String strb = String.valueOf(b);
            if(stra.charAt(0) != strb.charAt(0)){
                return strb.compareTo(stra);
            }else{
                return (strb+stra).compareTo(stra+strb);
            }
        }).forEach((num)->{
            if(sb.length() == 0 && num == 0){
                return;
            }
            sb.append(num.toString());
        });
        if(sb.length() == 0)
            sb.append('0');
        return sb.toString();
    }
}
