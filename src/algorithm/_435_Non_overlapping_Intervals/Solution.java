package algorithm._435_Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    /*题目描述：计算让一组区间不重叠所需要移除的区间个数。
    先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。在每次选择中，
    区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的
    区间个数也就越大。按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。*/


    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        //先根据每个区间end值进行排序
        Arrays.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        //初始值为1，表示不重叠区间的个数
        int count = 1;
        //第一个区间的end
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            //如果前一个区间的end大于后一个区间的start，就选择下一个区间
            if (intervals[i].start < end) {
                continue;
            }
            //该区间不重叠了，需要更新end值为该区间的end
            end = intervals[i].end;
            //不重叠区间的个数+1
            count++;
        }
        return intervals.length - count;
    }
}
