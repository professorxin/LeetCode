package algorithm._650_2_Keys_Keyboard;

public class Solution {

    /*最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
    Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
    Paste (粘贴) : 你可以粘贴你上一次复制的字符。
    给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印
    出 n 个 'A' 的最少操作次数。*/


    //动态规划做法
    /*dp[i]表示，通过复制粘贴操作，得到 i 个字符，最少需要几步操作。
    如果一个数是素数，那么最少操作就是一开始复制一个，最后一个个粘贴；
    如果一个数不是素数，那么最少操作就可以按它的因数分解一下，简化操作。*/
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                }
            }
        }
        return dp[n];
    }



    //递归做法
    public int minSteps1(int n) {
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            //如果能被整除，表示需要minSteps1(n/i)次操作加上i次（1次复制和i-1次粘贴）
            if (n % i == 0) {
                return i + minSteps1(n / i);
            }
        }
        return n;
    }
}
