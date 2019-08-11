package algorithm._011_Container_With_Most_Water;

public class Solution {

    /*给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
    垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。*/
    //示例图片在images文件夹

    //定义双指针
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            //求最大面积
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            //如果右边大，移动左指针。如果左边大，移动右指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
