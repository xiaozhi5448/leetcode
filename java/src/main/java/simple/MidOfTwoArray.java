package simple;

public class MidOfTwoArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int[] s_arr, l_arr;
        if(nums1.length < nums2.length){
            s_arr = nums1;
            l_arr = nums2;
        }else{
            s_arr = nums2;
            l_arr = nums1;
        }
        int total_length = s_arr.length + l_arr.length;
        int index1=0, index2 = 0;
        int final_index = total_length / 2;
        int current_index = 0;
        for(int index = 0; index < total_length; index++){
            if(nums1[index1] <= nums2[index2]){
                current_index = index1;
                index1 ++;
            }else{
                current_index = index2;
                index2++;
            }
        }

        if(total_length % 2 == 1){



        }else{


        }
        return result;
    }
}
