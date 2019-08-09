package algorithm._406_Queue_Reconstruction_by_Height;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
    k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。*/


    //以这个为例[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    public int[][] reconstructQueue(int[][] people) {
        //先将数组按下面规则排好序，规则就是身高相等的话按k升序，不等的话按身高降序
        //排好的顺序为[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        //遍历排序好的数组，按照k的值作为链表的索引值，当插入链表已有的索引值时，会右移原有元素
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
