package algorithm._059_Spiral_Matrix_II;

public class Solution {

    /*给定一个正数n，生成一个螺旋顺序为1-n^2的矩阵*/

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //向右扫描
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = num++;
            }
            rowBegin++;
            //向下扫描
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;
            //向左扫描
            for (int i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = num++;
            }
            rowEnd--;
            //向上扫描
            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = num++;
            }
            colBegin++;
        }
        return matrix;
    }
}
