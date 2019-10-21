package algorithm._072_Edit_Distance;

public class Solution {

    /*给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
    你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符
    */


    //定义一个dp二维数组，表示第一个字符串的前i位和第二个字符串的前j位所需要的操作的次数
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始状态值，如果第二个字符串为空
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        //初始状态值，如果第一个字符串为空
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果第i个字符和第j个字符匹配相同的时候
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //如果不相同的时候要考虑三种情况,这三种情况保证操作之后能让它们相同
                    //替换字符，dp[i-1][j-1]
                    //插入字符，dp[i][j-1]
                    //删除字符，dp[i-1][j]
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
