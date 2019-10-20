package algorithm._038_Count_and_Say;

public class Solution {

    /*报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
    1 被读作  "one 1"  ("一个一") , 即 11。
    11 被读作 "two 1s" ("两个一"）, 即 21。
    21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
    给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
    注意：整数顺序将表示为一个字符串。*/

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char say = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != say) {
                    sb.append(count).append(say);
                    say = s.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count).append(say);
            s = sb.toString();
        }
        return s;
    }


}
