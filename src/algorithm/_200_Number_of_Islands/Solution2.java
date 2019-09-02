package algorithm._200_Number_of_Islands;

public class Solution2 {

    /*给定一个二维数组，1表示土地，0表示水，连着的1表示一个岛屿，求岛屿的数量*/

    //并查集解决

    int[][] distance = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                            int id1 = i * cols + j;
                            int id2 = x * cols + y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }
}


class UnionFind{
    int[] father;
    int count = 0;

    public UnionFind(char[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        father = new int[rows * cols];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(grid[i][j] == '1'){
                    int id = i * cols +j;
                    father[id] = id;
                    count++;
                }
            }
        }
    }

    public int find(int p){
        while(p != father[p]){
            p = father[p];
        }
        return p;
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot != qRoot){
            father[pRoot] = qRoot;
            count--;
        }
    }
}


