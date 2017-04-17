package other.hiho.练习14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 礼物 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = a[i] + a[j];
                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int j = i;
            for (int k = i + 1; k < n; k++) {
                if (a[k] != a[i])
                    break;
                j = k;
            }
            cnt.put(a[i], j - i + 1);
            i = j;
        }

        long ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    long tmp = map.get(a[i] + a[j]) - cnt.get(a[i]) * (cnt.get(a[i]) - 1) / 2;
                    ret += tmp;
                    if (cnt.get(a[i]) >= 4) {
                        ret += (cnt.get(a[i]) - 2) * (cnt.get(a[i]) - 3) / 2;
                    }
                } else {
                    long tmp = map.get(a[i] + a[j]) - cnt.get(a[i]) * cnt.get(a[j]);
                    ret += tmp;
                    if (cnt.get(a[i]) > 1 && cnt.get(a[j]) > 1)
                        ret += (cnt.get(a[i]) - 1) * (cnt.get(a[j]) - 1);
                }
            }
        }
        System.out.println(ret);
    }
}




