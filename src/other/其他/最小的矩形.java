package other.其他;

import java.util.Scanner;

/**
 * N个点，且都是整点。现在画出一个矩形，使得这N个点都在矩形内或者在矩形上。
 * 矩形的边均平行于坐标轴。计算下最小矩形的面积
 *
 * @author scolphew
 */
public class 最小的矩形 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }
        int a1, a2, b1, b2;
        a1 = nums[0][0];
        a2 = nums[0][0];
        b1 = nums[0][1];
        b2 = nums[0][1];
        for (int i = 1; i < n; i++) {
            if (nums[i][0] < a1)
                a1 = nums[i][0];
            else if (nums[i][0] > a2)
                a2 = nums[i][0];

            if (nums[i][1] < b1)
                b1 = nums[i][1];
            else if (nums[i][1] > b2)
                b2 = nums[i][1];
        }
        System.out.println(Math.abs(a1 - a2) * Math.abs(b1 - b2));
    }
}
