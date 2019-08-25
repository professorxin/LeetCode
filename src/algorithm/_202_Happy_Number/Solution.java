package algorithm._202_Happy_Number;

public class Solution {

    /*判断一个数字是否是快乐数*/

    /*一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
    然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那
    么这个数就是快乐数。*/

    public boolean isHappy(int n) {
        //定义快指针和满指针
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            //如果能变为1表示是快乐数
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    //计算平方和
    private int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
