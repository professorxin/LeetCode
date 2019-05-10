package algorithm._605_Can_Place_Flowers;

public class Solution {

    /*给定一个数组，数组里面1表示种了花朵，0表示没有种。看能否种下n朵花，要求种的花不能相邻*/
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;
        for (int i = 0; i < len && count < n; i++) {
            //判断是否种了花
            if (flowerbed[i] == 1) {
                continue;
            }
            //左边是否种了
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            //右边是否种了
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            //如果左边和右边都没有花就种下
            if (pre == 0 && next == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        //数量相等表示都能种下
        return count == n;
    }
}
