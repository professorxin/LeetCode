package algorithm;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] num=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    if(nums[i]+nums[j]==target){
                        //return new int[] {i,j};
                        num[0]=i;
                        num[1]=j;
                        return num;
                    }
                }
            }
        }
        return null;
    }
}
