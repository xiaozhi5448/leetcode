package string;

import java.util.Arrays;
import java.util.HashMap;

public class SamePatternString_205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> maps = new HashMap<>();
        HashMap<Character, Character> mapt = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }else{
            for(int i = 0; i< s.length();i++){
                if(!maps.containsKey(s.charAt(i))){
                    maps.put(s.charAt(i), t.charAt(i));
                }else{
                    if(maps.get(s.charAt(i)) != t.charAt(i)){
                        return false;
                    }
                }
                if(!mapt.containsKey(t.charAt(i))){
                    mapt.put(t.charAt(i), s.charAt(i));
                }else{
                    if(mapt.get(t.charAt(i)) != s.charAt(i)){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public boolean isIsomorphic2(String s, String t) {
        int[] maps = new int[26];
        int[] mapt = new int[26];
        Arrays.fill(maps, -1);
        Arrays.fill(mapt, -1);
        for(int i = 0; i< s.length();i++){
            if(maps[s.charAt(i) - 'a'] == -1){
                maps[s.charAt(i) -'a'] = t.charAt(i);
            }else{
                if(maps[s.charAt(i) -'a'] != t.charAt(i)){
                    return false;
                }
            }
            if(mapt[t.charAt(i) -'a'] == -1){
                mapt[t.charAt(i) -'a'] = s.charAt(i);
            }else{
                if(mapt[t.charAt(i) - 'a'] != s.charAt(i)){
                    return false;
                }
            }

        }
        return true;
    }

}
