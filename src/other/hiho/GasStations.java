package other.hiho;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 */
public class GasStations {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "" + x + "," + y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int k = in.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.x * a.y - a.x * b.y);

        int p = in.nextInt();
        for (int i = 0; i < N - 1; i++) {
            int n = in.nextInt();
            pq.add(new Pair(n - p, 1));
            p = n;
        }

        while (k-- > 0) {
            Pair pair = pq.poll();
            pair.y += 1;
            pq.add(pair);
        }

        double ans = 0;
        for (Pair pair : pq) {
            ans = Math.max(ans, 1.0 * pair.x / pair.y);
        }
        System.out.printf("%.1f", ans);
    }
}
