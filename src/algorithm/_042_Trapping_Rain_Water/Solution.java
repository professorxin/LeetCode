package algorithm._042_Trapping_Rain_Water;

public class Solution {

    /*给定一个数组，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水*/

    //时间复杂度O(N)，空间复杂度O(1)，计算每个位置的上方能有多少水，然后累加
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int res = 0;
        //L指针左边最大值
        int leftMax = height[0];
        //R指针右边最大值
        int rightMax = height[height.length - 1];
        //左指针
        int L = 1;
        //右指针
        int R = height.length - 2;
        //当左右指针相遇的时候一旦错过（L>R）就结束
        while (L <= R) {
            if (leftMax < rightMax) {
                res += Math.max(leftMax - height[L], 0);
                //更新左边最大值，移动左指针
                leftMax = Math.max(leftMax, height[L++]);
            } else {
                res += Math.max(rightMax - height[R], 0);
                //更新右边最大值，移动右指针
                rightMax = Math.max(rightMax, height[R--]);
            }
        }
        return res;
    }
}
