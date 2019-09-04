package algorithm._155_Min_Stack;

import java.util.Stack;

public class MinStack {

    /*设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
    push(x) -- 将元素 x 推入栈中。
    pop() -- 删除栈顶的元素。
    top() -- 获取栈顶元素。
    getMin() -- 检索栈中的最小元素。
    */


    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;


    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        //如果放入的元素比最小值小，那么会保留之前的最小值入栈，然后更新新的最小值，再把新的最小值入栈
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int peek = stack.pop();
        //如果栈顶弹出来的元素和最小值相等，继续弹出之前的最小值，并将最小值更新为之前的最小值
        if (peek == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
