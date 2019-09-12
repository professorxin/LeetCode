package algorithm._135_Candy;

import java.util.Arrays;

public class Solution {

    /*老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
    你需要按照以下要求，帮助老师给这些孩子分发糖果：
    每个孩子至少分配到 1 个糖果。
    相邻的孩子中，评分高的孩子必须获得更多的糖果。
    那么这样下来，老师至少需要准备多少颗糖果呢？*/

    //从左向右和从右向左两个方向都要去匹配相应的规则，所以最后是取这两个方向所更新的糖果数的最大值
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] counts = new int[length];
        Arrays.fill(counts, 1);
        //从左向右
        for (int i = 1; i < length; i++) {
            //如果后面的孩子比前面的孩子评分高，更新糖果数
            if (ratings[i] > ratings[i - 1]) {
                counts[i] = counts[i - 1] + 1;
            }
        }
        //从右到左
        for (int i = length - 1; i > 0; i--) {
            ////如果前面的孩子比后面的孩子评分高，更新糖果数，取最大值作为最终结果
            if (ratings[i - 1] > ratings[i]) {
                counts[i - 1] = Math.max(counts[i - 1], counts[i] + 1);
            }
        }
        int result = 0;
        for (int count : counts) {
            result += count;
        }
        return result;
    }
}
