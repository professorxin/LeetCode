package algorithm._394_Decode_String;

import java.util.Stack;

public class Solution {

    /*给定一个经过编码的字符串，返回它解码后的字符串。
    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string
    正好重复 k 次。注意 k 保证为正整数。*/

    //使用两个栈，一个用于统计次数，一个用于统计括号内的结果
    public String decodeString(String s) {
        String res = "";
        Stack<String> resStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            //如果是数字
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                //通过位数确定数字大小
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + s.charAt(idx) - '0';
                    idx++;
                }
                //保存次数
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                //保存之前的字符串
                resStack.push(res);
                //更新字符串，用于后面的统计
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                //取出之前的字符串，用于叠加新统计的字符串
                StringBuilder temp = new StringBuilder(resStack.pop());
                //重复的次数
                int repeatTime = countStack.pop();
                for (int i = 0; i < repeatTime; i++) {
                    //旧的字符串叠加上次数*新的字符串
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                //叠加字符
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
