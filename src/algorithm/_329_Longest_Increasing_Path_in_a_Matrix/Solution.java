package algorithm._329_Longest_Increasing_Path_in_a_Matrix;

public class Solution {

    /*给定一个整数矩阵，找出最长递增路径的长度。
    对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外
    （即不允许环绕）。*/


    //深度优先遍历

    private int rows;
    private int cols;
    private int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        //记忆化搜索，保存了每个点的最长递增路径长度
        int[][] cache = new int[rows][cols];
        int result = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //从每个点出发去搜索最长路径
                result = Math.max(result, dfs(matrix, i, j, cache));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        //不为0，表示已经搜素过，直接返回
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[i][j]) {
                //满足递增条件
                int len = 1 + dfs(matrix, x, y, cache);
                //该点四个方向的最大值为该点的最长递增长度
                max = Math.max(max, len);
            }
        }
        //记录该点最长递增长度
        cache[i][j] = max;
        return max;
    }
}
