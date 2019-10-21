package algorithm._067_Add_Binary;

public class Solution {

    //题目描述：给定两个二进制字符串，相加后返回字符串

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0, sum;
        //如果字符串长度大于0就进入循环
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            //添加二进制取值
            sb.append(sum % 2);
            //有无进位
            carry = sum / 2;
        }
        //有进位才添加
        if (carry != 0) sb.append(carry);
        //我认为最关键是要能想到最后字符串反转
        return sb.reverse().toString();
    }
}
