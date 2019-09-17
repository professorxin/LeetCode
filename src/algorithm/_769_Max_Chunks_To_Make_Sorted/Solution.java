package algorithm._769_Max_Chunks_To_Make_Sorted;

public class Solution {

    /*数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将
    这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
    我们最多能将数组分成多少块？*/


    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int right = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            //找到一块逆序，可以来一次排序
            if (right == i) {
                count++;
            }
        }
        return count;
    }


}
