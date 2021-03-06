package string;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 挨个按列存储，上下扫描即可
 */
public class Ztransfer_6 {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        char[] chs = s.toCharArray();
        int row = Math.min(numRows, s.length());
        ArrayList<StringBuilder> items = new ArrayList<>(row);
        for(int i = 0; i< row; i++){
            items.add(new StringBuilder());
        }
        int step = 1, rowIndex = 0;
        boolean down = true;
        for(int i = 0; i < chs.length; i++){
            items.get(rowIndex).append(chs[i]);
            if(rowIndex == row-1){
                down = false;
            }else if(rowIndex == 0){
                down = true;
            }
            step = down? 1:-1;
            rowIndex += step;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb: items){
            res.append(sb.toString());
        }
        return res.toString();
    }
}
