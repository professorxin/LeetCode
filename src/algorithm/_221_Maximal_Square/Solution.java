package algorithm._221_Maximal_Square;

public class Solution {

    /*给定一个二维数组，找到最大的数字为1的正方形，返回面积*/

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = 0;
        //定义一个dp数组，数组的值dp[i][j]表示以原来二维数组的i-1，j-1这一格为右下角的正方形边长
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                //原来的数组有1的情况下才去更新值，否则就是0
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    //更新最大正方形边长
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        //面积
        return result * result;
    }
}
