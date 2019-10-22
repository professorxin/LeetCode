package algorithm._739_Daily_Temperatures;

import java.util.Stack;

public class Solution {

    /*给定一个日常温度的数组T,需要返回一个数组，数组里面记录了还需要等待多少天才能有更高的温度*/

    public int[] dailyTemperatures(int[] T) {
        //用栈来保存每一天
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            //栈不是空的并且当前天的温度大于栈顶该天的温度
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                //栈顶的天数
                int index = stack.pop();
                //更新result数组的栈顶天数需要等待的天数
                result[index] = i - index;
            }
            //将天数入栈
            stack.push(i);
        }
        return result;
    }
}
