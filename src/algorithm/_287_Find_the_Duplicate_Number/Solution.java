package algorithm._287_Find_the_Duplicate_Number;

public class Solution {

    //todo

    /*找出数组中重复的数，数组值在 [1, n] 之间*/
    public int findDuplicate(int[] nums) {
        //定义最小值1，最大值n
        int l = 1, h = nums.length - 1;
        //这个l和h代表的不是边界，而是值
        while (l <= h) {
            //计算出中间值
            int mid = l + (h - l) / 2;
            int cnt = 0;
            //计算整个数组中比中间值小的元素的个数
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) cnt++;
            }
            //如果元素个数大于中间值，说明重复的值在l到mid之间，否则重复的值在mid+1到h之间
            if (cnt > mid) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{1,3,4,2,2}));
    }
}
