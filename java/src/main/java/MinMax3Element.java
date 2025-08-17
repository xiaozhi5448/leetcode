import java.util.*;

public class MinMax3Element {

    private void swap(int[] nums, int left, int right){
        if(left == right){
            return;
        }
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    /**
     * 查找两个数组中最小和最大的三个元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[][] minMax3Element(int[] nums1, int[] nums2){
        // 考虑 nums1 或 nums2 为null 的情况
        if(nums1 == null && nums2 == null){
            return null;
        }
        Set<Integer> elements = new HashSet<>();
        if(nums1 != null){
            Arrays.stream(nums1).forEach(elements::add);
        }
        if(nums2 != null){
            Arrays.stream(nums2).forEach(elements::add);
        }
        int[] nums = new int[elements.size()];
        int i = 0;
        for(Integer num: elements){
            nums[i++] = num;
        }

        int sortEpoch = Math.min(3, elements.size());
        for(int j = 0; j < sortEpoch; j++){
            for(int k = j+1; k < elements.size(); k++){
                if(nums[j] > nums[k]){
                    swap(nums, j, k);
                }
            }
        }
        for(int j = 0; j < sortEpoch; j++){
            int pos = nums.length - j - 1;
            for(int k = pos-1; k >= 0; k--){
                if(nums[k] > nums[pos]){
                    swap(nums, pos, k);
                }
            }
        }

        int bound = Math.min(3, nums.length);
        int[] min3Ele = new int[bound];
        int[] max3Ele = new int[bound];
        for(int index = 0; index < bound; index++){
            min3Ele[index] = nums[index];
            max3Ele[index] = nums[nums.length - index - 1];
        }
        return new int[][]{min3Ele, max3Ele};
    }

    private boolean powerOf2(int n){
        return (n&(n-1)) == 0;
    }

    private boolean allVisited(boolean[] flags){
        for(Boolean flag: flags){
            if(!flag){
                return false;
            }
        }
        return true;
    }

    private boolean backtrack(int[] nums, boolean[] flags, int prev){
        if(allVisited(flags)){
            return powerOf2(prev);
        }
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(flags[i]){
                continue;
            }
            if(prev == 0 && nums[i] == 0){
                continue;
            }
            flags[i] = true;
            res.add(backtrack(nums, flags, prev* 10 + nums[i]));
            flags[i] = false;
        }
        return res.stream().anyMatch(flag  -> flag);
    }

    public boolean reorderedPowerOf2(int n) {
        String s = String.valueOf(n);
        int[] bytes = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            bytes[i] = s.charAt(i) - '0';
        }
        return backtrack(bytes, new boolean[s.length()], 0);
    }

    int[] parseNumCntArr(int n){
        int[] res = new int[10];
        int remain = n;
        while(remain != 0){
            int pivot = remain % 10;
            remain = remain / 10;
            res[pivot]++;
        }
        return res;
    }

    boolean arrayEquals(int[] nums1, int[] nums2){
        return Arrays.equals(nums1, nums2);
    }

    public boolean reorderedPowerOf(int n){
        int[] origin = parseNumCntArr(n);
        long start = 1;
        List<int[]> pairs = new ArrayList<>();
        while(start < Math.pow(10, 9)){
            pairs.add(parseNumCntArr((int)start));
            start = start * 2;
        }
        return pairs.stream().anyMatch(nums -> arrayEquals(nums, origin));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m-1;
        int ptr2 = n-1;
        int resIndex = nums1.length-1;
        while(ptr1 >= 0 && ptr2 >= 0){
            if(nums1[ptr1] > nums2[ptr2]){
                nums1[resIndex] = nums1[ptr1];
                ptr1--;
            }else{
                nums1[resIndex] = nums2[ptr2];
                ptr2--;
            }
            resIndex--;
        }
        while(ptr1 >= 0){
            nums1[resIndex--] = nums1[ptr1--];
        }
        while(ptr2 >= 0){
            nums1[resIndex--] = nums2[ptr2--];
        }
    }
}
