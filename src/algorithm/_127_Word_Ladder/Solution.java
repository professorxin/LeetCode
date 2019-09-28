package algorithm._127_Word_Ladder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /*给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
    转换需遵循如下规则：
    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。*/


    //使用广度优先搜索（BFS）
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        int start = n - 1;
        int end = 0;
        while (end < n && !endWord.equals(wordList.get(end))) {
            end++;
        }
        if (end == start) {
            return 0;
        }
        //构建集合数组，集合中的值为该数组的下标值能连接的点
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int n = wordList.size();
        List<Integer>[] graphic = new List[n];
        for (int i = 0; i < n; i++) {
            graphic[i] = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (connect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    //判断是否能连接，也就是字符不同的数量是否为1
    private boolean connect(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length() && diff <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    //使用队列去保存每一层的结点
    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graphic.length];
        queue.add(start);
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            //遍历一层结点
            while (size-- > 0) {
                int cur = queue.poll();
                List<Integer> list = graphic[cur];
                for (Integer num : list) {
                    //已经访问过，不能加入队列
                    if (visited[num]) {
                        continue;
                    }
                    //找到终点
                    if (num == end) {
                        return path;
                    }
                    //标记已经访问
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
        return 0;
    }
}
