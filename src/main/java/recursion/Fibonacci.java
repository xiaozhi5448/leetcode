package recursion;

import java.util.LinkedList;
import java.util.List;

public class Fibonacci {
    public int fib(int n) {
        if(n == 1 || n == 2){
            return 1;
        }else{
            List<Integer> nums = new LinkedList<Integer>();
            nums.add(1);
            nums.add(1);
            for(int i = 2; i< n; i++){
                nums.add(nums.get(nums.size()-1) + nums.get(nums.size() -2));
            }
            return nums.get(nums.size() -1);
        }
    }
}
