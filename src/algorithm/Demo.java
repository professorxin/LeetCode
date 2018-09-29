package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),nums,0);
        return list;
    }

    void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int start){
        templist.add(1);
        //list.add(new ArrayList<>(templist));
        list.add(templist);
        templist.add(2);
        //list.add(new ArrayList<>(templist));
        list.add(templist);

    }

    public static void main(String[] args){
        int[] nums={1};
        System.out.println(new Demo().subsets(nums));
    }
}
