package algorithm._547_Friend_Circles;

public class Solution {


    /*班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，
    B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
    给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个
    学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。*/


    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        //标记是否已经访问过
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            //如果没有被访问过
            if (!visited[i]) {
                //一次dfs结束，就能标记完一个朋友圈，count数量加1
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                //是朋友关系，标记已经访问
                visited[j] = true;
                //以标记结点为起始点继续标记其他朋友
                dfs(M, visited, j);
            }
        }
    }
}
