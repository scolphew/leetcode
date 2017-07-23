package other.hiho;

import java.util.Scanner;

public class 大礼堂地毯 {

    static String base[] = new String[50];
    static String p[] = new String[100];
    static int N;
    static int M;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        int K = in.nextInt();

        for (int j = 0; j < N; j++) {
            base[j] = in.next();
        }
        int H, W;
        for (int i = 0; i < K; i++) {
            H = in.nextInt();
            W = in.nextInt();
            for (int j = 0; j < H; j++) {
                p[j] = in.next();
            }
            if (foo(H, W)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }


    public static boolean foo(int H, int W) {

        for (int i = N; i < H; i++) {
            if (!p[i].equals(p[i - N]))
                return false;
        }

        int r = W / M + 1;
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = "";
            for (int j = 0; j < r; j++) {
                strings[i] += base[i];
            }
        }
        int index = -1;
        if (H >= N) {
            a:
            for (int i = 0; i < N; i++) {
                index = -1;
                for (int j = 0; j < N; j++) {
                    int tmp = strings[(j + i) % N].indexOf((p[j]), index);
                    if (tmp == -1) {
                        continue a;
                    }
                    index = Math.max(tmp, index);
                }
                for (int j = 0; j < N; j++) {
                    if (strings[(j + i) % N].indexOf((p[j]), index) != index) {
                        continue a;
                    }
                }
                break;
            }
        } else {
            b:
            for (int i = 0; i < N; i++) {
                index = -1;
                for (int j = 0; j < H; j++) {
                    int tmp = strings[(j + i) % N].indexOf((p[j]), index);
                    if (tmp == -1) {
                        continue b;
                    }
                    index = Math.max(tmp, index);
                }
                for (int j = 0; j < H; j++) {
                    if (strings[(j + i) % N].indexOf((p[j]), index) != index) {
                        continue b;
                    }
                }
                break;
            }
        }
        return index != -1;
    }

}
