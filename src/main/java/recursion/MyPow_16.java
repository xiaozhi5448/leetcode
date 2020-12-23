package recursion;

import java.math.BigInteger;

public class MyPow_16 {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }else if(n<0){
            return 1/x*myPow(1/x, -n-1);
        }
        if(n%2==0){
            return myPow(x*x, n/2);
        }else{
            return myPow(x*x, n/2)*x;
        }
    }
}
