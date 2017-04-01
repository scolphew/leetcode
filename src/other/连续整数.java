package other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author scolphew
 */
public class 连续整数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        boolean flag = false;
        Integer res = null;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 2) {
                if (!flag) {
                    res = nums[i] - 1;
                    flag = true;
                } else {
                    System.out.println("mistake");
                    return;
                }
            } else if (nums[i] - nums[i - 1] != 1) {
                System.out.println("mistake");
                return;
            }
        }
        if (res == null) {
            int a = nums[0] - 1;
            int b = nums[n - 1] + 1;
            if (a < 1)
                System.out.println(b);
            else
                System.out.println(a + " " + b);
        } else {
            System.out.println(res);
        }
    }
}
