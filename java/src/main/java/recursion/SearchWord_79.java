package recursion;

import java.util.LinkedList;
import java.util.List;

public class SearchWord_79 {
    private boolean visit(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        boolean res = false;
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            if (board[row][col] == word.charAt(index) && !visited[row][col]) {
                visited[row][col] = true;
                res = dfs(board, visited, row, col, word, index + 1);
                visited[row][col] = false;
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        boolean upper = false, lower = false, left = false, right = false;
        if (index >= word.length()) {
            return true;
        } else {
            upper = visit(board, visited, row - 1, col, word, index);
            if (upper) return true;
            lower = visit(board, visited, row + 1, col, word, index);
            if (lower) return true;
            left = visit(board, visited, row, col - 1, word, index);
            if (left) return true;
            right = visit(board, visited, row, col + 1, word, index);
            if (right) return true;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited;
        if (board.length > 0) {
            visited = new boolean[board.length][board[0].length];
        } else {
            return false;
        }
        List<Boolean> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    boolean tmp = dfs(board, visited, i, j, word, 1);
                    res.add(tmp);
                    visited[i][j] = false;
                }
            }
        }
        for (Boolean val : res) {
            if (val) {
                return true;
            }
        }
        return false;
    }
}
