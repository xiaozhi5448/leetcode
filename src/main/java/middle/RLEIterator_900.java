package middle;

public class RLEIterator_900 {
    int[] nums;
    int current_index = 0;
    public RLEIterator_900(int[] A) {
        nums = A;
    }

    public int next(int n) {
        if(current_index >= nums.length){
            return -1;
        }else{
            int count = n;
            while(count > 0){
                while(nums[current_index] <= 0){
                    current_index += 2;
                    if(current_index >= nums.length){
                        return -1;
                    }
                }
                if(count > nums[current_index]){
                    count -= nums[current_index];
                    nums[current_index] = 0;

                }else{
                    nums[current_index] -= count;
                    return nums[current_index + 1];
                }
            }
            return nums[current_index + 1];
        }
    }
}
