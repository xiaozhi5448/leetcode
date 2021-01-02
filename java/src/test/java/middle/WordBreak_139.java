package middle;

import java.util.List;

public class WordBreak_139 {
    int max_len = 0;
    int min_len = Integer.MAX_VALUE;
    private boolean findWordFromDict(List<String> dict, String msg){
        for(String ele: dict){
            if(ele.equals(msg)){
                return true;
            }
        }
        return false;
    }
    private void findMaxLen(List<String> dict){
        for(String ele: dict){
            int len = ele.length();
            max_len = len > max_len? len: max_len;
            min_len = len < min_len? len: min_len;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        findMaxLen(wordDict);
        int word_len = 0;
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length() + 1; i++){
            if(i < min_len)
                dp[i] = false;
            else{
                for(String word: wordDict){
                    word_len = word.length();
                    if(i - word_len < 0){
                        continue;
                    }else{
                        if(findWordFromDict(wordDict, s.substring(i - word_len, i))){
                            if(dp[i - word_len] == true){
                                dp[i] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[s.length()];

    }
}
