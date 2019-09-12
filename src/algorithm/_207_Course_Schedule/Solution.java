package algorithm._207_Course_Schedule;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /*现在你总共有 n 门课需要选，记为 0 到 n-1。
    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，
    我们用一个匹配来表示他们: [0,1]
    给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？*/


    /*拓扑排序的实现步骤
    1.在有向图中选一个没有前驱的顶点并且输出
    2.从图中删除该顶点和所有以它为尾的弧（白话就是：删除所有和它有关的边）
    3.重复上述两步，直至所有顶点输出，或者当前图中不存在无前驱的顶点为止*/

    //采用拓扑排序解决，如果是拓扑排序，就是无环的有向图，反之有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        //计算课程的入度
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        //如果入度为零，加入队列中
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            numCourses--;
            //将入度为零的课程弹出
            int course = queue.poll();
            //把入度为零的课程作为先修课程的要将入度数减一
            for (int[] pair : prerequisites) {
                if (pair[1] == course) {
                    indegree[pair[0]]--;
                    //如果入度数为0，加入队列
                    if (indegree[pair[0]] == 0) {
                        queue.add(pair[0]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}
