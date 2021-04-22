package sort;

import java.util.TreeSet;

public class Duplicated3_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> window = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            if(window.contains((long)nums[i]) || window.contains((long)nums[i] - t)){
                return true;
            }
            Long nearest = window.ceiling((long)nums[i] - t);
            if(nearest != null && nearest <= (long)nums[i] + t){
                return true;
            }
            window.add((long)nums[i]);
            if(i >= k){
                window.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
