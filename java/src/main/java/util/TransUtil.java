package util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public  class TransUtil {
    public static List<Integer> convertStrToList(String info){
        info = info.replaceAll("\\[|\\]", "");
        info = info.trim();
        String[] items = info.split(",");
        return Arrays.stream(items).map((item)->(Integer.parseInt(item))).collect(Collectors.toList());
    }

    public static int[] convertStrToArr(String info){
        List<Integer> items = convertStrToList(info);
        int[] nums = new int[items.size()];
        for(int i = 0; i < items.size(); i++){
            nums[i] = items.get(i);
        }
        return nums;
    }

    public static List<List<Integer>> convertStrToList2(String info){
        info = info.substring(1, info.length()-1);
        List<List<Integer>> res = new LinkedList<>();
        String[] levels = info.split("\\]\\s*,");
        for(String level: levels){
            res.add(convertStrToList(level));
        }
        return res;
    }
    public static int[][] convertStrToArr2(String info){
        List<List<Integer>> items = convertStrToList2(info);
        int[][] nums = new int[items.size()][];
        for(int i = 0; i < items.size(); i++){
            int[] line = new int[items.get(i).size()];
            for(int j = 0; j < items.get(i).size(); j++){
                line[j] = items.get(i).get(j);
            }
            nums[i] = line;
        }
        return nums;
    }
}
