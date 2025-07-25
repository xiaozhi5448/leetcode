package dfs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinTimeToReach_3341 {
    /**
     * 3341. Find Minimum Time to Reach Last Room I
     * Medium
     * Topics
     * Companies
     * Hint
     * There is a dungeon with n x m rooms arranged as a grid.
     *
     * You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes exactly one second.
     *
     * Return the minimum time to reach the room (n - 1, m - 1).
     *
     * Two rooms are adjacent if they share a common wall, either horizontally or vertically.
     *
     *
     *
     * Example 1:
     *
     * Input: moveTime = [[0,4],[4,4]]
     *
     * Output: 6
     *
     * Explanation:
     *
     * The minimum time required is 6 seconds.
     *
     * At time t == 4, move from room (0, 0) to room (1, 0) in one second.
     * At time t == 5, move from room (1, 0) to room (1, 1) in one second.
     * Example 2:
     *
     * Input: moveTime = [[0,0,0],[0,0,0]]
     *
     * Output: 3
     *
     * Explanation:
     *
     * The minimum time required is 3 seconds.
     *
     * At time t == 0, move from room (0, 0) to room (1, 0) in one second.
     * At time t == 1, move from room (1, 0) to room (1, 1) in one second.
     * At time t == 2, move from room (1, 1) to room (1, 2) in one second.
     * Example 3:
     *
     * Input: moveTime = [[0,1],[1,2]]
     *
     * Output: 3
     *
     *
     *
     * Constraints:
     *
     * 2 <= n == moveTime.length <= 50
     * 2 <= m == moveTime[i].length <= 50
     * 0 <= moveTime[i][j] <= 109
     */
    public int minTimeToReach(int[][] moveTime) {
        return dijstra(moveTime);
    }

    public int minTimeToReach2(int[][] moveTime) {
        return dijstraWithLength(moveTime);
    }

    private int dfs(int[][] moveGrid, boolean[][] visited, int i, int j, int currentTime, int minTime){
        if(i == moveGrid.length-1 && j == moveGrid[0].length - 1){ // 到达目的地
            return Math.min(currentTime, minTime);
        }
        int[] rowIndex = new int[]{-1, 1, 0, 0};
        int[] colIndex = new int[]{0, 0, -1, 1};
        int posTimeLimit = -1;
        int res = Integer.MAX_VALUE;
        for(int index = 0; index < 4; index++){

            int r = i + rowIndex[index];
            int c = j + colIndex[index];
            if(r < 0 || c < 0 || r >= moveGrid.length || c >= moveGrid[0].length){
                continue;
            }
            if(visited[r][c]){
                continue;
            }
            posTimeLimit = moveGrid[r][c];
            visited[r][c] = true;
            int minT = dfs(moveGrid, visited, r, c, Math.max(currentTime, posTimeLimit) + 1, minTime);
            res = Math.min(minT, res);
            visited[r][c] = false;

        }
        return res;
    }

    private int dijstra(int[][] moveGrid){
        int rowCount = moveGrid.length;
        int colCount = moveGrid[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        int[][] distance = new int[rowCount][colCount];
        for(int i = 0; i < rowCount; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        int[] rowPivot = new int[]{-1, 1, 0, 0};
        int[] colPivot = new int[]{0, 0, -1, 1};

        PriorityQueue<Point> heap = new PriorityQueue<>();
        heap.add(new Point(0, 0, 0));
        while(!heap.isEmpty()){
            Point nearestPoint = heap.poll();
            if(visited[nearestPoint.x][nearestPoint.y]){
                continue;
            }
            visited[nearestPoint.x][nearestPoint.y] = true;
            for(int i = 0; i< 4; i++){
                int row = nearestPoint.x + rowPivot[i];
                int col = nearestPoint.y + colPivot[i];
                if(row < 0 || row >= rowCount || col < 0 || col >= colCount){
                    continue;
                }
                int neighbourDistance = Math.max(nearestPoint.distance, moveGrid[row][col]) + 1;
                if(neighbourDistance < distance[row][col]){
                    distance[row][col] = neighbourDistance;
                    heap.offer(new Point(row, col, neighbourDistance));
                }
            }
        }
        return distance[rowCount-1][colCount-1];
    }

    private int dijstraWithLength(int[][] moveGrid){
        int rowCount = moveGrid.length;
        int colCount = moveGrid[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        int[][] distance = new int[rowCount][colCount];
        for(int i = 0; i < rowCount; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE - 1000);
        }
        distance[0][0] = 0;
        int[] rowPivot = new int[]{-1, 1, 0, 0};
        int[] colPivot = new int[]{0, 0, -1, 1};

        PriorityQueue<Point> heap = new PriorityQueue<>();
        heap.add(new Point(0, 0, 0, 0));
        while(!heap.isEmpty()){
            Point nearestPoint = heap.poll();
            if(visited[nearestPoint.x][nearestPoint.y]){
                continue;
            }
            visited[nearestPoint.x][nearestPoint.y] = true;
            for(int i = 0; i< 4; i++){
                int row = nearestPoint.x + rowPivot[i];
                int col = nearestPoint.y + colPivot[i];
                if(row < 0 || row >= rowCount || col < 0 || col >= colCount){
                    continue;
                }
                if(visited[row][col]){
                    continue;
                }
                int pathLen = nearestPoint.pathLength + 1;
                int neighbourDistance = Math.max(nearestPoint.distance, moveGrid[row][col]) + (pathLen % 2 == 0? 2: 1);
                if(neighbourDistance < distance[row][col]){
                    distance[row][col] = neighbourDistance;
                    heap.offer(new Point(row, col, neighbourDistance, nearestPoint.pathLength + 1));
                }
            }
        }
        return distance[rowCount-1][colCount-1];
    }

    public static class Point implements Comparable{
        int x;
        int y;
        int distance;
        int pathLength;

        public Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.distance = dis;


        }public Point(int x, int y, int dis, int pathLength){
            this.x = x;
            this.y = y;
            this.distance = dis;
            this.pathLength = pathLength;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            return distance - p.distance;
        }
    }
}
