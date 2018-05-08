package lsf.java._134_GasStation;

public class Solution {
    /**
     * 还行公里，第i个加油站有gas[i]油，到下一个加油站消耗cost[i]油，
     * 求从某一起点开始可以跑完全程，否则返回-1
     *
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }
        int sum = 0;
        for (int i = 0; i < 2 * gas.length - 1; i++) { //保证每个加油站作为起点
            sum += gas[i % gas.length];
            if (sum < 0) { //说明这个加油站耗油量大于存量，不能作为起点。
                res = i + 1;
                if (res >= gas.length)
                    return -1;
                sum = 0;
            }
        }
        return res;
    }
}
