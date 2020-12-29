package GreedyStrategy;

public class FillArray_330 {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int x = 1;
        int index = 0;
        while(x <= n){
            if(index < nums.length && nums[index] <= x){
                x+= nums[index];
                index++;
            }else{
                x *= 2;
                count++;
            }

        }
        return count;
    }

}
