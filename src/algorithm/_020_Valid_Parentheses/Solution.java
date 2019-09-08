package algorithm._020_Valid_Parentheses;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    /*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
    */

    //使用数据结构栈来判别给定字符串的符号是否排列规范
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
