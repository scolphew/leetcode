package lsf.java._03_._319_BulbSwitcher;

public class Solution {
    /**
     * 关灯,一共n个灯，操作n轮，第i轮会切换i的倍数的编号的灯的状态，求n论之后开着的等的数量
     * <p>
     * 解法：每个灯会在它的因子的轮数是切换状态，所以当编号有奇数个因子时他会开着，
     * 而有奇数个因子的数是完全平方数，因为
     * 因子是成对出现的，如12=1*12=2*6=3*4
     * 只有当16=4*4这种情况时，两个因子相等会出现奇数的情况，
     * 因此，结果如下
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

}
