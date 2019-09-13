package algorithm._621_Task_Scheduler;

import java.util.Arrays;

public class Solution {

    /*给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种
    不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何
    一个单位时间内都可以执行一个任务，或者在待命状态。
    然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执
    行不同的任务，或者在待命状态。
    你需要计算完成所有任务所需要的最短时间。*/


    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        for (char c : tasks) {
            chars[c - 'A']++;
        }
        //按频率排序，可以找到使用频率最高的值
        Arrays.sort(chars);
        int i = 25;
        //确定使用频率最高的值相同的字符有多少个
        while (i >= 0 && chars[i] == chars[25]) i--;
        //考虑间隔长度n可能为零，所以最短时间可能是数组长度
        return Math.max(tasks.length, (chars[25] - 1) * (n + 1) + 25 - i);
    }

}
