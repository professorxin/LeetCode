package algorithm._264_Ugly_Number_II;

public class Solution {

    /*编写一个程序，找出第 n 个丑数。丑数就是只包含质因数 2, 3, 5 的正整数。*/

    public int nthUglyNumber(int n) {
        if (n < 6) {
            return n;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int next2 = nums[i2] * 2, next3 = nums[i3] * 3, next5 = nums[i5] * 5;
            //最小值就是下一个丑数
            nums[i] = Math.min(next2, Math.min(next3, next5));
            if (nums[i] == next2) i2++;
            if (nums[i] == next3) i3++;
            if (nums[i] == next5) i5++;
        }
        return nums[n - 1];
    }
}
