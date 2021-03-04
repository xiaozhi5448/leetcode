package search;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 */
public class BSearchString {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length-1;
        while(left <= right){
            while(words[left].equals("")) left++;
            while(words[right].equals("")) right--;
            if(words[left].equals(s)) return left;
            if(words[right].equals(s)) return right;
            int mid = (left+right)/2;
            int tmp = mid;
            while(tmp < right&& words[tmp].equals("")) tmp++;
            if(tmp == right)
                break;
            int compRes = s.compareTo(words[tmp]);
            if(compRes == 0){
                return tmp;
            }else if(compRes > 0){
                left = tmp+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}
