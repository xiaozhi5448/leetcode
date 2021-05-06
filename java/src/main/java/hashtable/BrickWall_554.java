package hashtable;

import java.util.*;

/**
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。
 * 这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。
 * 其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。
 * 你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 */
public class BrickWall_554 {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0)
            return 0;
        List<Set<Integer>> levelBounds = new LinkedList<>();
        Set<Integer> bounds = new HashSet<>();
        for(List<Integer> level: wall){
            int prefixSum = level.get(0);
            Set<Integer> currentLevel = new HashSet<>();
            for(int i = 1; i < level.size(); i++){
                currentLevel.add(prefixSum);
                bounds.add(prefixSum);
                prefixSum += level.get(i);
            }
            levelBounds.add(currentLevel);
        }
        if(bounds.isEmpty()){
            return wall.size();
        }
        int res = Integer.MAX_VALUE;
        for(Integer bound: bounds){
            long count = levelBounds.stream().filter((level) -> (!level.contains(bound))).count();
            res = Math.min(res, (int)count);
        }
        return res;
    }

    public  int leastBricks2(List<List<Integer>> wall){
        Map<Integer, Integer> breaks = new HashMap<>();
        for(List<Integer> level: wall){
            int prefixSum = level.get(0);
            for(int i = 1; i < level.size(); i++){
                breaks.put(prefixSum, breaks.getOrDefault(prefixSum, 0)+1);
                prefixSum+= level.get(i);
            }
        }
        int var = 0;
        for(Map.Entry<Integer, Integer> entry: breaks.entrySet()){
            var = Math.max(var, entry.getValue());
        }
        return wall.size() - var;
    }
}
