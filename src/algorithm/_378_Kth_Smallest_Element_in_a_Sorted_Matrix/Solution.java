package algorithm._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

public class Solution {

    /*给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
    请注意，它是排序后的第k小元素，而不是第k个元素。*/


    //基于二分查找实现。该算法最后的目的是会找出满足条件的最小值，该最小值肯定在矩阵中
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        //矩阵的最小值和最大值
        int lo = matrix[0][0], high = matrix[rows - 1][cols - 1];
        while (lo < high) {
            int mid = lo + (high - lo) / 2;
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols && matrix[i][j] <= mid; j++) {
                    count++;
                }
            }
            //小于中间数的数量比k小，取右半部分
            if (count < k) {
                lo = mid + 1;
            } else {
                high = mid;
            }
        }
        return lo;
    }

}
