package algorithm._050_Pow;

public class Solution {
    //我一开始用for循环，time limit，可能计算量太大,而且方法太暴力。
    //使用递归才是正确做法，
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            //如果n是最小值的话就要把它变大，不然加负号会溢出
            if (n == Integer.MIN_VALUE) {
                n /= 2;
                x *= x;
            }
            n = -n;
            x = 1 / x;
        }
        //递归调用，底数平方，指数减半
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
