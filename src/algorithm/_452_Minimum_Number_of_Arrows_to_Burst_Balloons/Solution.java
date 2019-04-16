package algorithm._452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    /*题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都会刺破。
    求解最小的投飞镖次数使所有气球都被刺破。*/
    //其实题目就是要计算不重叠区间的数量
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //将把数组按照后面那位数进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //默认第一个是不重叠的，所以初始数量为1
        int count = 1;
        //第一个区间的末尾
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            //后一个区间的开始<=前一个区间的结束，就直接continue
            if (points[i][0] <= end) {
                continue;
            }
            count++;
            end = points[i][1];
        }
        return count;
    }
}
