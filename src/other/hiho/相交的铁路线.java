package other.hiho;

import java.util.*;

public class 相交的铁路线 {

    static int[] tree = new int[100001];
    static int[] level = new int[100001];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();

            for (int j = 0; j < n - 1; j++) {
                int a = in.nextInt();
                int b = in.nextInt();
                tree[b] = a;
            }

            for (int j = 0; j < n + 1; j++) {
                level[j] = 0;
            }


            for (int j = 0; j < m; j++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();

                int t1 = lca(a, b);
                int t2 = lca(c, d);

                boolean ans = false;
                int t = lca(t1, t2);
                if (t == t1) {
                    if (isAncestors(t2, a) || isAncestors(t2, b))
                        ans = true;
                } else if (t == t2) {
                    if (isAncestors(t1, c) || isAncestors(t1, d))
                        ans = true;
                }
                System.out.println(ans ? "YES" : "NO");

            }
        }
    }

    public static boolean isAncestors(int a, int b) {
        if (a == 1)
            return true;
        while (b != a && b != 1) {
            b = tree[b];
        }
        return b == a;
    }

    public static int getLevel(int x) {
        if (level[x] != 0)
            return level[x];
        int ans = 0;
        int tmp = x;
        while (tmp != 1) {
            tmp = tree[tmp];
            ans++;
        }
        if (level[x] == 0)
            level[x] = ans;
        return ans;

    }

    public static int lca(int a, int b) {
        if (a == 1)
            return 1;
        int la = getLevel(a);
        int lb = getLevel(b);

        while (la > lb) {
            a = tree[a];
            la--;
        }
        while (lb > la) {
            b = tree[b];
            lb--;
        }
        while (a != b) {
            a = tree[a];
            b = tree[b];
        }
        return a;
    }
}
