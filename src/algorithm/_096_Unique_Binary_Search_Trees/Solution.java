package algorithm._096_Unique_Binary_Search_Trees;

public class Solution {
    /*给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？*/

    /*
    G(n) = F(1, n) + F(2, n) + ... + F(n, n).
    G(0)=1, G(1)=1.
    F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
    G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
    函数F(i,n)表示n个结点以i为根节点的二叉搜索树，函数G(n)表示n个结点组成二叉搜索树的种数
    */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            //该循环表示G(i) = F(1, i) + F(2, i) + ... + F(i, i)
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
