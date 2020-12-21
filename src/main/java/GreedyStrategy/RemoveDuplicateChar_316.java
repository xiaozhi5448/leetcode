package GreedyStrategy;

public class RemoveDuplicateChar_316 {
    public int findChar(char[] chs, boolean[] duplicated, int end, char ch){
        for(int i = 0; i<end; i++){
            if(chs[i] == ch && !duplicated[i]){
                return i;
            }
        }
        return -1;
    }
    public String removeDuplicateLetters(String s) {
        char[] chs = s.toCharArray();
        boolean[] duplicated = new boolean[s.length()];
        int index = 1;
        while(index < s.length()){
            int find_res = findChar(chs,duplicated, index, chs[index]);
            if(find_res != -1){
                int nextChIndex = find_res + 1;
                while(duplicated[nextChIndex]) nextChIndex++;
                if(chs[find_res] >= chs[nextChIndex]){
                    duplicated[find_res] = true;
                }else{
                    duplicated[index] = true;
                }
            }
            index++;

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< chs.length; i++){
            if(!duplicated[i]){
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }
}
