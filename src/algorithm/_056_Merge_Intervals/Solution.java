package algorithm._056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /*给定一组区间，合并所有重叠的区间*/
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        //先把区间按照开始值来排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果后一个区间的开始值小于等于前一个区间的结束值，更新结束值。反之添加上一个区间并更新开始和结束值
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        //添加最后一个区间
        list.add(new int[]{start, end});
        //转化为二维数组返回
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
