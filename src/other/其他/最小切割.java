package other.其他;

import java.util.Scanner;

/**
 * 把长为L的模板切割为L1，L2..Ln的小木板，每次切割的代价为模板长度，求最小代价
 * 例：21 = 8 + 8 + 5
 * 则先把21切割为13+8，再把13切割为8+5，代价为21+13=34
 * <p>
 * 思路：赫夫曼树
 *
 * @author scolphew
 */
public class 最小切割 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int ans = 0;
        while (n > 1) {
            int min1 = 0;
            int min2 = 1;
            if (nums[min1] > nums[min2]) {
                int tmp = min1;
                min1 = min2;
                min2 = tmp;
            }
            for (int i = 2; i < n; i++) {
                if (nums[i] < nums[min1]) {
                    min2 = min1;
                    min1 = i;
                } else if (nums[i] < nums[min2]) {
                    min2 = i;
                }
            }
            int t = nums[min1] + nums[min2];
            ans += t;
            if (min1 == n - 1) {
                int tmp = min1;
                min1 = min2;
                min2 = tmp;
            }
            nums[min1] = t;
            nums[min2] = nums[n - 1];
            n--;
        }
        System.out.println(ans);
    }
}
