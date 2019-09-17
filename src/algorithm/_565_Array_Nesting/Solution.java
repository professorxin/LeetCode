package algorithm._565_Array_Nesting;

public class Solution {

    /*索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回最大的集合S，
    S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

    假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是
    A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。*/

    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            //从该数字开始访问
            for (int j = i; nums[j] != -1; ) {
                count++;
                int t = nums[j];
                //标记已经使用过
                nums[j] = -1;
                j = t;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
