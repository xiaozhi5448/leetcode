package hashtable;

import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 *     数字 1-9 在每一行只能出现一次。
 *     数字 1-9 在每一列只能出现一次。
 *     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 */
public class ValidateSuku_36 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer>[] rowMap = new HashMap[9];
        HashMap<Character, Integer>[] colMap = new HashMap[9];
        HashMap<Character, Integer>[] boxMap = new HashMap[9];
        for(int i = 0; i< 9; i++){
            rowMap[i] = new HashMap<>();
            colMap[i] = new HashMap<>();
            boxMap[i] = new HashMap<>();
        }
        for(int row=0; row <9; row++){
            for(int col = 0; col < 9; col++){
                // 注意尚未补齐的数字，直接跳过
                if(board[row][col] == '.')
                    continue;
                int boxIndex = (row/3)*3 + (col/3);
                if(boxMap[boxIndex].containsKey(board[row][col])){
                    return false;
                }
                boxMap[boxIndex].put(board[row][col], 1);
                if(rowMap[row].containsKey(board[row][col])){
                    return false;
                }
                if(colMap[col].containsKey(board[row][col])){
                    return false;
                }
                rowMap[row].put(board[row][col], 1);
                colMap[col].put(board[row][col], 1);
            }
        }
        return true;
    }
}
