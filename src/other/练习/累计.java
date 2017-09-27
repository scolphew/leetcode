package other.练习;

import java.util.Scanner;

public class 累计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //int n = in.nextInt();
        System.out.println(m(2, 3, 255));
    }

    public static int n(int m, int n) {

        int zuigaowei = (int) Math.log(m) + 1;
        int leiji = 0;
        for (int i = 0; i < 10; i++) {
            int num = m(i, zuigaowei, m);
            if (leiji + num < n) {
                leiji += num;
            } else {

            }
        }
        return 0;
    }

    public static int m(int i, int j, int m) {
        int ans = 0;

        int k = 1;
        while (k < j) {
            ans += Math.pow(10, k - 1);
            k += 1;
        }

        int j_00 = (int) (Math.pow(10, j - 1));
        int m_showwei = m / j_00;

        if (m_showwei == i) {
            ans += m - i * j_00 + 1;
        } else if (m_showwei > i) {
            ans += Math.pow(10, k - 1);
        }
        return ans;
    }
}
