package algorithm._405_Convert_a_Number_to_Hexadecimal;

public class Solution {

    /*给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用补码运算方法。*/

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder stb = new StringBuilder();
        while (num != 0) {
            //0b1111表示1111是个二进制
            stb.append(map[num & 0b1111]);
            //因为考虑的是补码形式，因此符号位就不能有特殊的意义，所以无符号右移四位
            num >>>= 4;
        }
        return stb.reverse().toString();
    }
}
