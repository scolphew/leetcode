package other.hiho;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SplitArray {

    /**
     * 给一个排好序的数组，和整数k
     * 将数组分解为若干个长度为k的子序列，每个子序列刚好是连续递增数列
     * 如：
     * {1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6} 转换为
     * {1, 2, 3}, {1, 2, 3}, {3, 4, 5}, {4, 5, 6}.
     * 输出YES或NO
     * 输入：
     * 第一行，测试组数
     * 每一组数据两行：
     * 第一行，数组长度和k
     * 第二行：数组内容
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            foo(in);
        }
    }

    public static void foo(Scanner in) {
        int n = in.nextInt();
        int k = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
                pq.add(tmp);
            }
        }

        if (n % k != 0) {
            System.out.println("NO");
            return;
        }
        int m = n / k;

        for (int i = 0; i < m; i++) {
            int min = pq.peek();//获得最小值

            for (int j = min; j < min + k; j++) {
                if (map.containsKey(j)) {
                    int count = map.get(j);
                    if (count == 1) {
                        //只剩一个了
                        map.remove(j);
                        pq.remove(j);
                    } else {
                        //还有，删除一个
                        map.put(j, count - 1);
                    }
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");


    }

}
