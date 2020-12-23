package recursion;

import java.util.*;

public class StringCombine_17 {
    List<String> combs = new LinkedList<String>();
    HashMap<Integer, List<Character>> dict = new HashMap<>();
    String digits;
    public StringCombine_17(){
        dict.put(2, Arrays.asList('a', 'b', 'c'));
        dict.put(3, Arrays.asList('d', 'e', 'f'));
        dict.put(4, Arrays.asList('g', 'h', 'i'));
        dict.put(5, Arrays.asList('j', 'k', 'l'));
        dict.put(6, Arrays.asList('m', 'n', 'o'));
        dict.put(7, Arrays.asList('p', 'q', 'r', 's'));
        dict.put(8, Arrays.asList('t', 'u', 'v'));
        dict.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    private void letterCombUtil(String meta, int index){
        if(index >= digits.length()){
            combs.add(meta);
        }else{
            int num = digits.charAt(index) - '0';
            for(Character ch: dict.get(num)){
                letterCombUtil(meta + ch, index + 1);
            }
        }

    }
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if(digits.length() != 0)
            letterCombUtil("", 0);
        return combs;
    }
}
