package search;


/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 *
 * 二分查找降低时间复杂度
 */
public class Sqrt_69 {
    public int mySqrt(int x) {
        if(x<0){
            return -1;
        }else if(x <= 1){
            return x;
        }else{
            int left = 1;
            int right = x;
            int mid;
            while(left < right){
                mid = (right-left)/2 + left;
                if(mid == left){
                    return  left;
                }
                if((long)mid*mid == x){
                    return mid;
                }else if((long)mid*mid > x){
                    right = mid;
                }else{
                    left = mid;
                }
            }
            return left;
        }
    }
}
