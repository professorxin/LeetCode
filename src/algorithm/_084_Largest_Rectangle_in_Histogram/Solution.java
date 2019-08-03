package algorithm._084_Largest_Rectangle_in_Histogram;

public class Solution {

    /*给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    求在该柱状图中，能够勾勒出来的矩形的最大面积。*/

    /*对柱形图中的每一个非负整数m来说，向左边找到第一个比它小的数字i，向右边找到第一个比它小的数字j，矩形的大小
    等于该非负整数m乘以（右边数字j的下标-左边数字i的下标-1），这样算出来的矩形的长可以表示为[i+1,j-1],宽就是
    该非负整数的值。只需遍历整个数组，就可得出矩形的最大值*/
    //时间复杂度为O(n)
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        //向左查找到的第一个比它小的数字的下标
        int[] lessFromLeft = new int[heights.length];
        //向右查找到的第一个比它小的数字的下标
        int[] lessFromRight = new int[heights.length];
        lessFromLeft[0] = -1;
        lessFromRight[heights.length - 1] = heights.length;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            //使用p = lessFromLeft[p]而不是p--,能让时间复杂度从O（n^2）变为O(n)
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }


        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        //遍历数组，更新矩形的最大面积
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }
}
