package algorithm._130_Surrounded_Regions;

public class Solution {

    /*给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。*/

    private int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows, cols;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        rows = board.length;
        cols = board[0].length;

        //左边界和右边界
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        //上边界和下边界
        for (int i = 0; i < cols; i++) {
            dfs(board, 0, i);
            dfs(board, rows - 1, i);
        }

        //遍历二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    //深度优先遍历，让边界O和与边界O相连的O全部变为T
    private void dfs(char[][] board, int r, int c) {
        if (r >= rows || r < 0 || c >= cols || c < 0 || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        for (int[] d : direction) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}
