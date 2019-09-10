package algorithm._583_Delete_Operation_for_Two_Strings;

public class Solution {

    /*给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
    每步可以删除任意一个字符串中的一个字符。*/

    //转化为计算两个字符串的公共字符串
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        //两个字符串相加的长度减去公共字符串
        return m + n - 2 * dp[m][n];
    }
}
