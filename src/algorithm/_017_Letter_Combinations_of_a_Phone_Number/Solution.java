package algorithm._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*电话号码按钮，给定一个字符串，返回该字符串代表的字母的所有可能组合*/

    //分别表示0-9代表的数字
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        //回溯
        doCombination(res, new StringBuilder(), digits);
        return res;
    }

    public void doCombination(List<String> res, StringBuilder str, String digits) {
        //终止条件，长度相同
        if (str.length() == digits.length()) {
            res.add(str.toString());
            return;
        }
        //求出当前数字
        int cur = digits.charAt(str.length()) - '0';
        //找出当前数字表示的字符串
        String letter = KEYS[cur];
        for (char c : letter.toCharArray()) {
            //添加元素
            str.append(c);
            doCombination(res, str, digits);
            //删除元素，从而实现回溯
            str.deleteCharAt(str.length() - 1);
        }
    }
}
