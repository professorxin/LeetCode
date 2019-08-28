package algorithm._695_Max_Area_of_Island;

public class Solution {

    /*给定一个包含了一些 0 和 1的非空二维数组 grid ,一个岛屿是由四个方向 (水平或垂直) 的 1 (代表土地)
    构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
    找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)*/


    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        //遍历二维数组，依次以每个点作为起点进行dfs,找到最大的面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }


    public int dfs(int[][] grid, int r, int c) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == 0) {
            return 0;
        }
        //标记已经处理
        grid[r][c] = 0;
        //处理上下左右四个方向
        return 1 + dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }
}
