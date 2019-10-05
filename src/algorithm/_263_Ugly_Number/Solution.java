package algorithm._263_Ugly_Number;

public class Solution {

    /*编写一个程序判断给定的数是否为丑数。丑数就是只包含质因数 2, 3, 5 的正整数。*/

    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
