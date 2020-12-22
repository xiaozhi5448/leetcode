package GreedyStrategy;

public class RemoveDuplicateChar_316 {
    public int findChar(char[] chs, boolean[] duplicated,int start, int end, char ch){
        for(int i = start; i<end; i++){
            if(chs[i] == ch && !duplicated[i]){
                return i;
            }
        }
        return -1;
    }
    public int findPrevIndex(boolean[] duplicated, int end){
        for(int i = end -1;i>=0;i--){
            if(!duplicated[i]){
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
            if(findChar(chs, duplicated, 0,index, chs[index]) != -1){
                duplicated[index] = true;
            }else{
                int prevIndex = findPrevIndex(duplicated, index);
                while(chs[index] < chs[prevIndex]){
                    // delete chs[index -1]
                    if(findChar(chs,duplicated, index +1, chs.length, chs[prevIndex]) != -1){
                        duplicated[prevIndex] = true;
                    }else{
                        break;
                    }
                    prevIndex= findPrevIndex(duplicated, index);
                    if(prevIndex < 0||duplicated[prevIndex]){
                        break;
                    }
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
