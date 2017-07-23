package other.hiho;

import java.util.Scanner;

public class 压缩字符串 {

    static int[][] dp = new int[100][100];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < s.length(); k++) {
                    dp[j][k] = 0;
                }
            }
            char[] s1 = s.toCharArray();
            int tmp = foo(s1, 0, s.length() - 1);
            System.out.println(tmp);
        }

    }


    public static int foo(char[] s, int l, int r) {
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        if (l == r) {
            dp[l][r] = 1;
            return 1;
        }
        int ans = r - l + 1, n = ans;
        for (int i = l; i < r; i++) {
            ans = Math.min(ans, foo(s, l, i) + foo(s, i + 1, r));
        }
        outer:
        for (int i = 2; i <= n; i++) {  //分成i份
            if (n % i == 0) {
                int len = n / i;  //每份长度
                int k1 = l, k2 = l + len;
                while (k2 <= r) {
                    if (s[k1] != s[k2])
                        continue outer;
                    k1++;
                    k2++;
                }
                int tmp = 2 + foo(s, l, l + len - 1) + bit(i);
                ans = Math.min(tmp, ans);
            }
        }
        dp[l][r] = ans;
        return ans;
    }

    public static int bit(int a) {
        int ans = 0;
        while (a > 0) {
            a /= 10;
            ans++;
        }
        return ans;
    }

}
