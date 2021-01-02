package data;

import java.util.HashMap;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> data = new HashMap<>();
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }else{
            for(int i = 0; i<pattern.length(); i++){
                if(!data.containsKey(pattern.charAt(i))){
                    if(data.containsValue(words[i])){
                        return false;
                    }
                    data.put(pattern.charAt(i), words[i]);
                }else{
                    if(!data.get(pattern.charAt(i)).equals(words[i])){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
