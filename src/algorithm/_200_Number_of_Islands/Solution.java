package algorithm._200_Number_of_Islands;

public class Solution {

    /*给定一个二维数组，1表示土地，0表示水，连着的1表示一个岛屿，求岛屿的数量*/


    //岛的行数和列数
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    //将周围的1全部感染为0
                    infect(grid, i, j);
                }
            }
        }
        return count;
    }

    //感染函数，可以将所有连续的1感染为0
    private void infect(char[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }
}
