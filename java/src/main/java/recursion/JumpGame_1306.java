package recursion;

import java.util.LinkedList;
import java.util.List;

public class JumpGame_1306 {
    boolean[] visited;
    boolean res = false;

    private void recursionUtil(int[] arr, int start) {
        if (arr[start] == 0) {
            res = true;
        }
        if (!visited[start]) {
            visited[start] = true;
            if (start - arr[start] >= 0) {
                recursionUtil(arr, start - arr[start]);
            }
            if (start + arr[start] < arr.length)
                recursionUtil(arr, start + arr[start]);
        }

    }

    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        recursionUtil(arr, start);
        return res;
    }
}
