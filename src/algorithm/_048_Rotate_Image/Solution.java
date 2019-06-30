package algorithm._048_Rotate_Image;

public class Solution {

    //将图像顺时针旋转90度


    //图形变化如下
    //  1  2  3     1  4  7     7  4  1
    //  4  5  6     2  5  8     8  5  2
    //  7  8  9     3  6  9     9  6  3

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
