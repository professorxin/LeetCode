package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    //回溯算法，这个不算特别能理解
    //类似于深度优先算法，先递归走到最底层，再递归返回，再去寻找
    public List<String> generateParenthesisOther(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){
        //结束条件，如果字符串的长度等于max的二倍
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        System.out.println(str);
        //如果左括号小于max
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        //如果右括号大于max
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String[] args){
        new GenerateParentheses().generateParenthesisOther(3);
    }
}


//假设n=3时，具体流程
/*
(
((
(((
((()
((())
((()))
(()
(()(
(()()
(()())
(())
(())(
(())()
()
()(
()((
()(()
()(())
()()
()()(
()()()
*/
