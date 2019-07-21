package algorithm._054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    /*返回该矩阵螺旋顺序的元素集合*/

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //向右扫描
            for (int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            //向下扫描
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            //验证当前行是否满足规则，因为要考虑是否是一行的情况
            if(rowBegin <= rowEnd){
                //向左扫描
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            //验证当前列是否满足规则，因为要考虑是否是一列的情况
            if(colBegin <= colEnd){
                //向上扫描
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        return result;
    }
}
