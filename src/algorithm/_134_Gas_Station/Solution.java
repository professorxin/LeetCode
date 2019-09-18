package algorithm._134_Gas_Station;

public class Solution {

    /*在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
    你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油
     cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
    如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。*/


    //如果总汽油小于总花费，那么肯定不行绕路一周，反之肯定可以。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            //油箱剩余油量
            tank += gas[i] - cost[i];
            //如果剩余油量小于0
            if (tank < 0) {
                //更新初始地址
                start = i + 1;
                //将油量重新设置为0
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }
}
