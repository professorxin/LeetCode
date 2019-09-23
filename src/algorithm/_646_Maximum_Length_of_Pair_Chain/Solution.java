package algorithm._646_Maximum_Length_of_Pair_Chain;

import java.util.Arrays;

public class Solution {

    /*给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
    现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。
    我们用这种形式来构造一个数对链。
    给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序
    选择其中的一些数对来构造。*/

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        int length = pairs.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
