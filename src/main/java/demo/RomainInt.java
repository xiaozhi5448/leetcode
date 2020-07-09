package demo;

import java.util.HashMap;

public class RomainInt {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        initMap(map);
        int res = 0, temp = 0;
        String substr;
        int i = 0;
        if(s.length() <= 2){
            if(map.containsKey(s)){
                return map.get(s);
            }else{
                return map.get(s.substring(0, 1)) + map.get(s.substring(1,2));
            }
        }
        for(;i + 1 < s.length(); i++){
            substr = s.substring(i, i + 2);
            if(map.containsKey(substr)){
                ++i;
                temp = map.get(substr);
            }else{
                temp =  map.get(s.substring(i, i+1));
            }
            res += temp;
        }
        if(map.containsKey(s.substring(i-1, i+1))){

        }else{
            substr = s.substring(i, i+1);
            res += map.get(substr);
        }
        return res;
    }
    private void initMap(HashMap<String,Integer> map){
       map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("L", 50);
        map.put("C", 100);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("CD", 400);
        map.put("CM", 900);

    }
    
}