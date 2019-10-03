package algorithm._069_Sqrt_x;

public class Solution {

    /*实现 int sqrt(int x) 函数。
    计算并返回 x 的平方根，其中 x 是非负整数。
    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。*/


    //平方根一定处于1-x之间
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        //二分查找
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt > mid) {
                l = mid + 1;
            } else if (sqrt < mid) {
                h = mid - 1;
            } else {
                return mid;
            }
        }
        //h比l要小，比如8是返回2，返回较小的。
        return h;
    }
}
