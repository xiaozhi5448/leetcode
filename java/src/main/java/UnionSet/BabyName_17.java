package UnionSet;

//每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。
//        有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。
//        给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。
//        设计一个算法打印出每个真实名字的实际频率。
//        注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，
//        即它们有传递和对称性。
//
//        在结果列表中，选择 字典序最小 的名字作为真实名字。

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//
class BabyNames_17 {
    private String parent(HashMap<String, String> parentMap, String name){
        String parentStr = parentMap.get(name);
        if(parentStr == null){
            parentMap.put(name, name);
            return name;
        }
        while(!parentStr.equals(parentMap.get(parentStr))){
            parentStr = parentMap.get(parentStr);
        }
        String rootStr = parentStr;
        parentStr = name;
        while(parentStr != rootStr){
            String p = parentMap.get(parentStr);
            parentMap.put(parentStr, rootStr);
            parentStr = p;
        }
        return parentStr;
    }

    private boolean merge(HashMap<String, String> parentMap, String name1, String name2){
        String p1 = parent(parentMap, name1);
        String p2 = parent(parentMap, name2);
        if(p1.compareTo(p2) < 0){
            parentMap.put(p2, p1);
        }else if(p1.compareTo(p2) > 0){
            parentMap.put(p1, p2);
        }else{
            return false;
        }
        return true;
    }
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        for(String name:names){
            int num_index = name.indexOf('(')+1;
            String nickname = name.substring(0, num_index-1);
            countMap.put(nickname, Integer.valueOf(name.substring(num_index,
                    name.length()-1)));
            if(!parents.containsKey(nickname)){
                parents.put(nickname, nickname);
            }
        }
        for(String pair: synonyms){
            int commaIndex = pair.indexOf(',');
            String name1 = pair.substring(1, commaIndex);
            String name2 = pair.substring(commaIndex+1, pair.length()-1);
            merge(parents, name1, name2);
        }
        HashMap<String, Integer> resMap = new HashMap<>();
        for(String key: parents.keySet()){
            if(key.equals(parents.get(key))){
                resMap.put(key, 0);
            }
        }
        for(String name: countMap.keySet()){
            String p = parent(parents, name);
            resMap.put(p, resMap.get(p) + countMap.get(name));
        }
        String[] arr = new String[resMap.size()];
        int index = 0;
        for(String name: resMap.keySet()){
            arr[index++] = String.format("%s(%d)", name, resMap.get(name));
        }
        return arr;
    }
}
