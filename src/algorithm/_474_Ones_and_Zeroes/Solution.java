package algorithm._474_Ones_and_Zeroes;

public class Solution {

    /*在计算机界中，我们总是追求用有限的资源获取最大的收益。
    现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
    你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。
    每个 0 和 1 至多被使用一次。*/


    /*多维费用的 0-1 背包问题，有两个背包大小，0 的数量和 1 的数量。*/
    //dp[i][j]表示i个0和j个1所能拼出数组中字符串的最大数量
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        //二维数组，表示0背包和1背包的组合背包
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int one = 0, zero = 0;
            //统计0和1的数量
            for (char c : chars) {
                if (c == '1') {
                    one++;
                } else if (c == '0') {
                    zero++;
                }
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
