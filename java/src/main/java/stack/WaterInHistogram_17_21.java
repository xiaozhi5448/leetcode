package stack;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 */
public class WaterInHistogram_17_21 {
    public int trap(int[] height) {
        if(height.length <= 2){
            return 0;
        }
        int[] rightMax = new int[height.length];
        int max = 0;
        for(int i = height.length-1; i>=0; i--){
            rightMax[i] = max;
            max = Math.max(max, height[i]);
        }
        int leftMax = height[0];
        int ret = 0;
        for(int i = 1; i < height.length; i++){
            int minHeight = Math.min(leftMax, rightMax[i]);
            if(minHeight > height[i]){
                ret += (minHeight-height[i]);
            }
            leftMax = Math.max(height[i], leftMax);
        }
        return ret;
    }
}
