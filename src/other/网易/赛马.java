package other.网易;

import java.util.Scanner;

/**
 * 在一条无限长的跑道上，有N匹马在不同的位置上出发开始赛马。
 * 当开始赛马比赛后，所有的马开始以自己的速度一直匀速前进。
 * 每匹马的速度都不一样，且全部是同样的均匀随机分布。
 * 在比赛中当某匹马追上了前面的某匹马时，被追上的马就出局。
 * 请问按以上的规则比赛无限长的时间后，赛道上剩余的马匹数量的数学期望是多少
 *
 * @author scolphew
 */
public class 赛马 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double nums[] = new double[n + 1];
        double A[][] = new double[n + 1][n + 1];

        nums[0] = 0;
        nums[1] = 1;
        A[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            A[i][0] = 1;
            A[i][1] = i;
            for (int j = 1; j <= i; j++) {
                A[i][j] = A[i][j - 1] * (i - j + 1);
            }
        }
        for (int i = 2; i <= n; i++) {
            double tmp = 0;
            for (int j = 1; j <= i; j++) {
                //tmp += A[i - 1][j - 1] * (nums[j - 1] + 1) + A[i - 1][i - j];
                tmp += A[i - 1][j - 1] * A[i - j][i - j] * (nums[j - 1] + 1);
            }
            nums[i] = tmp / A[i][i];
        }
        System.out.printf("%.4f\n", nums[n]);


        // 2
        double res = 0;
        for (double i = 1; i <= n; i++) {
            res += 1 / i;
        }
        System.out.printf("%.4f", res);
    }


}
