package matrix;

public class RotateImage_48 {
    /**
     *
     * 借助辅助矩阵，原矩阵第i行第j列的会出现在倒数第i列的第j行
     * @param matrix 二维数组
     */
    public void rotate(int[][] matrix) {
        int scale = matrix.length;
        int tmp[][] = new int[scale][scale];
        for(int row = 0; row < scale; row++){
            for(int col = 0; col <scale ; col++){
                tmp[col][scale - row -1] = matrix[row][col];
            }
        }
        for(int row = 0; row < scale; row++){
            for(int col = 0; col <scale ; col++){
                matrix[row][col] = tmp[row][col];
            }
        }
    }
    public  void rotate_2(int[][] matrix){
        int tmp;
        for(int row = 0; row < matrix.length /2 ;row++){
            for(int col = 0; col < matrix.length; col++){
                tmp = matrix[row][col];
                matrix[row][col] =  matrix[matrix.length - row -1][col];
                matrix[matrix.length - row -1][col] = tmp;
            }
        }
        for(int row = 0; row <matrix.length; row ++){
            for(int col = row + 1; col < matrix.length; col++){
                tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }
}
