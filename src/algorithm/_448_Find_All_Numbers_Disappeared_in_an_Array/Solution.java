package algorithm._448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，
    另一些只出现一次。找到所有在 [1, n] 范围之间没有出现在数组中的数字。时间复杂度o(n)*/


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            int val = Math.abs(nums[i]) - 1;
            //标记该位置的数为负数
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }
        }
        for(int i = 0;i < nums.length;i++){
            //如果为正数，表示该位置没有被标记过，也就表面该数组没有出现过这个数字
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }
}
