package recursion;

import java.util.Arrays;

public class JumpGame_1306 {
    private boolean reachRecursionUtil(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start >= arr.length) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        if (visited[start])
            return false;
        visited[start] = true;
        return reachRecursionUtil(arr, start - arr[start], visited) || reachRecursionUtil(arr, start + arr[start], visited);
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] flags = new boolean[arr.length];
        Arrays.fill(flags, false);
        boolean res = reachRecursionUtil(arr, start, flags);
        return res;
    }
}
