package string;

import java.util.HashSet;

public class FirstUniqChar_387 {
    private int findChar(char[] chs, char ch, int start){
        for(int i = start; i < chs.length; i++){
            if(chs[i] == ch){
                return i;
            }
        }
        return -1;
    }
    public int firstUniqChar(String s) {
        HashSet<Character> duplicated = new HashSet<>();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++){
            int find_res = s.indexOf(chs[i], i+1);
            if (!duplicated.contains(chs[i]) && find_res == -1){
                return i;
            }else{
                duplicated.add(chs[i]);
            }
        }
        return -1;
    }
}
