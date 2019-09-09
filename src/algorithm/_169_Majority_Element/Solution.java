package algorithm._169_Majority_Element;

public class Solution {


    /*给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。*/

    public int majorityElement(int[] num) {
        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            //如果count=0,重新在剩余的数字中找出众数
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3, 3, 2, 2, 3}));
    }
}
