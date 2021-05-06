package util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TransUtil {
    public List<Integer> convertStrToList(String info){
        info = info.replaceAll("\\[|\\]", "");
        info = info.trim();
        String[] items = info.split(",");
        return Arrays.stream(items).map((item)->(Integer.parseInt(item))).collect(Collectors.toList());
    }

    public List<List<Integer>> convertStrToList2(String info){
        info = info.substring(1, info.length()-1);
        List<List<Integer>> res = new LinkedList<>();
        String[] levels = info.split("\\]\\s*,");
        for(String level: levels){
            res.add(convertStrToList(level));
        }
        return res;
    }
}
