package other.hiho;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 放置矩形 {
    /**
     * 小Hi计划在笛卡尔平面中依次放置N个2x1的矩形(矩形的长是2，宽是1，长宽分别与XY轴平行)。
     * 其中第i个矩形的左下角预计放置在坐标(Xi, Yi)的位置上。
     * 如果放置某一个矩形时，发现会与之前放置的矩形相交(公共面积大于0)，
     * 就放弃放置当前矩形，继续尝试下一个矩形。
     * 给定N个矩形的放置顺序，请你帮小Hi计算他一共能放下多少个矩形？
     * <p>
     * 输入
     * 第一行包含一个整数N。
     * 以下N行包含N对整数Xi, Yi。
     * 1 <= N <= 100000
     * 0 <= Xi, Yi <= 1000000
     * 输出
     * 一个整数代表答案
     * 样例输入
     * 3
     * 0 0
     * 1 0
     * 2 0
     * 样例输出
     * 2
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Long> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            long x = a * 1000000l + b;
            long y = x + 1000000l;
            if ((!set.contains(x)) && (!set.contains(y))) {
                set.add(x);
                set.add(y);
                ans++;
            }
        }
        System.out.println(ans);
    }

}
