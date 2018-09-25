package algorithm;

import java.util.Stack;

public class ValidParentheses {
    //使用数据结构栈来判别符号是否排列规范
    public boolean isValidOther(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                //将“）”压栈
                stack.push(')');
            else if (c == '{')
                //将“}”压栈
                stack.push('}');
            else if (c == '[')
                //将“】”压栈
                stack.push(']');
            //取出栈的元素判断是否符合符号
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        //使用栈是否空来判断，空的话才是全部对应，并且都取出了
        return stack.isEmpty();
    }

}
