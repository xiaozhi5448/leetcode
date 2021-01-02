package recursion;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Fibonacci {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
       else if(n == 1){
            return 1;
        }else{
             BigInteger[] nums = new BigInteger[n+1];
            nums[0] = BigInteger.valueOf(0);
            nums[1] = BigInteger.valueOf(1);
            for(int i = 2; i < n+1; i++){
                nums[i] = nums[i-1].add(nums[i-2]);
            }
            int res = (int)(nums[n].mod(BigInteger.valueOf(1000000007)).intValue());

            return res;
        }
    }
    public int fib2(int n){
        if(n == 0 || n == 1){
            return n;
        }else{
            BigInteger num1 = BigInteger.valueOf(0);
            BigInteger num2 = BigInteger.valueOf(1);
            BigInteger num3 = BigInteger.valueOf(0);
            for(int i = 2; i< n+1; i++){
                num3 = num2.add(num1);
                num1 = num2;
                num2 = num3;
            }
            return num3.mod(BigInteger.valueOf(1000000007)).intValue();
        }
    }
}
