package algorithm._504_Base_7;

public class Solution {

    /*给定一个整数，将其转化为7进制，并以字符串形式输出。*/

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder stb = new StringBuilder();
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }
        while (num > 0) {
            //取余数
            stb.append(num % 7);
            num /= 7;
        }
        //字符串反转
        String res = stb.reverse().toString();
        return isNegative ? "-" + res : res;
    }
}
