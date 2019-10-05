package algorithm._946_Validate_Stack_Sequences;

import java.util.Stack;

public class Solution {

    /*给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的
    推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。*/


    //构造辅助栈
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        //出栈索引位
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            //如果栈不为空且栈顶元素等于出栈序列元素，就执行出栈操作并移动出栈索引
            while (!stack.empty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        //栈为空表示元素全部弹出了，返回true，否则返回false
        return stack.empty();
    }
}
