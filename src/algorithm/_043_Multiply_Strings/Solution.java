package algorithm._043_Multiply_Strings;

public class Solution {

    /*给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
    它们的乘积也表示为字符串形式。*/

    /*示例图在images文件夹*/

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        //m位数乘以n位数得到的结果就是m+n位数
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //p1表示进位的位置，p2表示个位的位置
                int p1 = i + j, p2 = i + j + 1;
                //两数乘积
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //乘积加上之前的乘积产生的进位的数字
                int sum = mul + pos[p2];

                //进位
                pos[p1] += sum / 10;
                //个位
                pos[p2] = sum % 10;
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int p : pos) {
            //数字0不能出现在首元素
            if (!(stb.length() == 0 && p == 0)) {
                stb.append(p);
            }
        }
        return stb.length() == 0 ? "0" : stb.toString();
    }
}
