package algorithm._032_Longest_Valid_Parentheses;

import java.util.Stack;

public class Solution {

    /*给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。*/

    //借助栈保存s中字符为‘（’的位置
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        //-1用于后续计算长度
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            //如果当前字符为）且栈顶数字表示的字符为（.要限制栈的大小大于1，不然一开始插入的-1会导致s.charAt()报错
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                //将(出栈
                stack.pop();
                //更新有效括号子串的最长长度
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }

    //todo 动态规划
}
