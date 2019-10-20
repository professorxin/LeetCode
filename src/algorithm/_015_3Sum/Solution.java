package algorithm._015_3Sum;

import java.util.*;

public class Solution {


    /*找出三个数字相加为0的所有组合*/

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num); //排序,这是很重要的一步
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            //为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以。
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                //两个指针,并且头指针从i + 1开始，尾指针从末尾开始，防止加入重复的元素
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //和后一个元素相同要后移，防止加入重复的 list
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }
                    //如果和小于sum，数值较小的头指针后移
                    else if (num[lo] + num[hi] < sum) lo++;
                        //如果和大于sum，数值较大的尾指针前移
                    else hi--;
                }
            }
        }
        return res;
    }
}
