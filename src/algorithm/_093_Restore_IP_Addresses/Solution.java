package algorithm._093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。*/

    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        backtrack(addresses, 0, tempAddress, s);
        return addresses;
    }

    private void backtrack(List<String> addresses, int k, StringBuilder tempAddress, String s) {
        //k表示ip地址组成部分的数量
        if (k == 4 || s.length() == 0) {
            ////由四个部分组成并且长度刚好用完
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        //IP的一部分的长度为3
        for (int i = 0; i < s.length() && i <= 2; i++) {
            //只能出现0，不能出现01，011这种
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            //生成ip地址的一部分
            String part = s.substring(0, i + 1);
            //判断该部分是否小于等于255
            if (Integer.valueOf(part) <= 255) {
                if (tempAddress.length() != 0) {
                    part = "." + part;
                }
                //拼接好一部分
                tempAddress.append(part);
                backtrack(addresses, k + 1, tempAddress, s.substring(i + 1));
                //删去最后一部分，达到回溯
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }
}
