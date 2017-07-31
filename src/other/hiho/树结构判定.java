package other.hiho;

import java.util.Scanner;

public class 树结构判定 {

    static int[] root = new int[501];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (m != n - 1) {
                for (int k = 0; k < m; k++) {
                    in.nextInt();
                    in.nextInt();
                }
                System.out.println("NO");
            } else
                isTree(in, n, m);
        }
    }

    private static void isTree(Scanner in, int n, int m) {
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (flag) {
                int root1 = root(a);
                int root2 = root(b);
                if (root1 == root2) {
                    flag = false;
                }
                root[root2] = root1;
            }
        }
        System.out.println(flag ? "YES" : "NO");


    }

    static int root(int i) {
        while (root[i] != i) {
            i = root[i];
        }
        return i;

    }

}
