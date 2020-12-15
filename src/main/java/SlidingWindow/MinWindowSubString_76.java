package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSubString_76 {

    private boolean check(HashMap<Character,Integer> originalMap, HashMap<Character, Integer> iterMap){
        if(iterMap.keySet().containsAll(originalMap.keySet())){
            for(Map.Entry<Character, Integer> entry: originalMap.entrySet()){
                if(entry.getValue() > iterMap.get(entry.getKey())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int length = Integer.MAX_VALUE;
        String res = "";
        HashSet<Character> originalSet;
        HashMap<Character, Integer> originalMap = new HashMap<>();
        Set<Character> iterSet;
        HashMap<Character, Integer> iterMap = new HashMap<>();
        for(int i = 0; i< t.length(); i++){
//            originalSet.add(t.charAt(i));
            if(!originalMap.containsKey(t.charAt(i))){
                originalMap.put(t.charAt(i), 1);
            }else{
                originalMap.put(t.charAt(i), originalMap.get(t.charAt(i)) + 1);
            }
        }
        int left = 0, right=0;
        while(left < s.length()){
            iterMap.entrySet().removeIf(entry -> entry.getValue() <= 0);
            if(!check(originalMap, iterMap)){
                if( right < s.length()){
//                    iterSet.add(s.charAt(right));
                    Character ch = s.charAt(right);
                    if(iterMap.containsKey(s.charAt(right))){

                        iterMap.put(ch, iterMap.get(ch) + 1);
                    }else{
                        iterMap.put(ch, 1);
                    }
                    right++;
                }else{
                    break;
                }

            }else{
                Character ch = s.charAt(left);
                if(right - left < length){
                    length = right-left;
                    res = s.substring(left, right);
                }
//                iterSet.remove(ch);
                if(iterMap.containsKey(ch)){
                    iterMap.put(ch, iterMap.get(ch) - 1);
                }

                left++;
            }

        }
        return res;
    }
}
