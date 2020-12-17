package hashtable;

import java.util.*;

public class StringClassify_49 {
    private String calStringKey(String str){
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
    private Integer calIntegerKey(String str){
        int res = 1;
        for(int i = 0; i< str.length(); i++){
            res *= str.charAt(i);
        }
        return res;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> data = new HashMap<>();
        for(String str: strs){
            String key = calStringKey(str);
            if(!data.containsKey(key)){
                data.put(key, new LinkedList<String>());
            }
            data.get(key).add(str);
        }
        List<List<String>> res = new LinkedList<List<String>>();
        for(Map.Entry<String, List<String>> entry: data.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
