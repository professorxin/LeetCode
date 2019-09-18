package algorithm._179_Largest_Number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    /*给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。*/

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                //定义升序
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(strs, comparator);
        if (strs[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder stb = new StringBuilder();
        for (String str : strs) {
            stb.append(str);
        }
        return stb.toString();
    }
}
