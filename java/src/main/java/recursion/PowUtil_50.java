package recursion;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 * 使用递归，将复杂度从n降到logn
 */
public class PowUtil_50 {
    private double recursionUtil(double x, int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }
        if(n%2 == 0){
            return recursionUtil(x*x, n/2);
        }else{
            return x*recursionUtil(x*x, n/2);
        }
    }
    public double myPow(double x, int n) {
        double res = recursionUtil(x, Math.abs(n));
        return n >= 0? res: 1.0/res;
    }
}
