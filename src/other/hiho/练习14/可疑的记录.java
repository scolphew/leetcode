package other.hiho.练习14;

import java.util.Scanner;

public class 可疑的记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a, b, expa = 0, expb = 0, expline = 0;
        int[] tree = new int[n + 1];
        int[] lineNum = new int[n + 1];
        tree[1] = 1;
        for (int i = 1; i <= n; i++) {
            a = in.nextInt();
            b = in.nextInt();
            if (tree[b] == 0) {
                tree[b] = a;
                lineNum[b] = i;
            } else {
                expa = a;
                expb = b;
                expline = i;
            }
        }
        if (expb == 1) {
            System.out.println(expline);
            return;
        }
        if (expa == tree[expb]) {
            System.out.println(lineNum[expb] + " " + expline);
            return;
        }
        boolean x = foo(tree, expb);
        int t1 = lineNum[expb];
        tree[expb] = expa;
        boolean y = foo(tree, expb);
        int t2 = expline;
        if (!x && !y) {
            System.out.println(t1 + " " + t2);
        }
        if (x) {
            System.out.println(t1);
        }
        if (y) {
            System.out.println(t2);
        }
    }

    static boolean foo(int[] tree, int x) {
        int tmp = tree[x];
        while (tmp != 1 && tmp != x) {
            tmp = tree[tmp];
        }
        if (tmp == 1)
            return false;
        return true;
    }
}
