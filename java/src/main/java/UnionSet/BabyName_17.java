package UnionSet;

//每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。
//        有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。
//        给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。
//        设计一个算法打印出每个真实名字的实际频率。
//        注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，
//        即它们有传递和对称性。
//
//        在结果列表中，选择 字典序最小 的名字作为真实名字。

import java.util.*;
import java.util.regex.*;
//
class BabyNames_17 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> nameToIndex = new HashMap<>();
        Map<String, Integer> nameToCount = new HashMap<>();
        Map<Integer, String> indexToName = new HashMap<>();
        int nameCount = 0;
        Pattern p = Pattern.compile("(\\w+)\\((\\d+)\\)");
        for(String comb: names){
            Matcher m = p.matcher(comb);
            if(m.find()){
                String name = m.group(1);
                int count = Integer.valueOf(m.group(2));
                nameToCount.put(name, count);
                if(!nameToIndex.containsKey(name)){
                    nameToIndex.put(name, nameCount);
                    indexToName.put(nameCount, name);
                    nameCount++;
                }
            }
        }

        UnionFind uf = new UnionFind(nameCount);
        p = Pattern.compile("\\((\\w+),(\\w+)\\)");
        for(String pair: synonyms){
            Matcher m = p.matcher(pair);
            if(m.find()){
                String name1 = m.group(1);
                String name2 = m.group(2);
                uf.union(nameToIndex.get(name1), nameToIndex.get(name2));
            }
        }
        Map<Integer, List<String>> trees = new HashMap<>();
        for(int i = 0; i < nameCount; i++){
            int root = uf.find(i);
            if(!trees.containsKey(root)){
                trees.put(root, new LinkedList<>());
            }
            trees.get(root).add(indexToName.get(i));
        }
        String[] res = new String[trees.size()];
        int index = 0;
        for(int root: trees.keySet()){
            int count = 0;
            for(String name: trees.get(root)){
                count += nameToCount.get(name);
            }
            Collections.sort(trees.get(root));
            String name = trees.get(root).get(0);
            res[index++] = String.format("%s(%d)", name, count);
        }
        return res;
    }
}
