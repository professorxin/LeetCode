package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    //回溯算法
    public List<String> generateParenthesisOther(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
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
