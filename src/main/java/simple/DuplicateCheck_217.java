package simple;

import java.util.HashMap;

public class DuplicateCheck_217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> iterMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!iterMap.containsKey(nums[i])){
                iterMap.put(nums[i], 1);
            }else{
                return true;
            }
        }
        return false;
    }
}
