package other.hiho;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 任务分配 {

    //给定 N 项任务的起至时间( S1, E1 ), ( S2, E2 ), ..., ( SN, EN )，
    // 计算最少需要多少台机器才能按时完成所有任务。
    //同一时间一台机器上最多进行一项任务，并且一项任务必须从头到尾保持在一台机器上进行。
    // 任务切换不需要时间。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n * 2][2];
        for (int i = 0; i < n; i++) {
            a[i * 2][0] = in.nextInt();
            a[i * 2][1] = 0;
            a[i * 2 + 1][0] = in.nextInt();
            a[i * 2 + 1][1] = 1;
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int num = 0;
        int max = 0;
        for (int[] i : a) {
            if (i[1] == 0) {
                num++;
                if (num > max)
                    max = num;
            } else
                num--;
        }
        System.out.println(max);
    }

}
