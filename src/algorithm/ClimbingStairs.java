package algorithm;

public class ClimbingStairs {
    //斐波拉契的思路
    //想象成一个数组，第n个位置的方法等于第n-1个位置的方法加上第n-2个位置的方法
    //第n-1个位置加1步就到达第n个位置，第n-2个位置加两步就到达第n个位置，解法加起来不会重复
    public int climbStairsOther(int n) {
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
            //第n个位置的方法等于第n-1个位置的方法加上第n-2个位置的方法
            all_ways = one_step_before + two_steps_before;
            //考虑如果i+1之后，第n-2变为n-1；
            two_steps_before = one_step_before;
            //考虑如果i+1之后，第n-1变为n；
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
