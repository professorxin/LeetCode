package algorithm._566_Reshape_the_Matrix;

public class Solution {

    /*给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
    重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
    如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。*/

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int rows = nums.length;
        int cols = nums[0].length;
        if (rows * cols != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[index / cols][index % cols];
                index++;
            }
        }
        return result;
    }
}
