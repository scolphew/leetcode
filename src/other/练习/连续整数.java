package other.练习;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author scolphew
 */
public class 连续整数 {
    /**
     * 牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，
     * 给牛牛猜他抹除掉的数字是什么。牛牛知道羊羊写的整数神排序之后是一串连续的正整数，
     * 牛牛现在要猜出所有可能是抹除掉的整数。例如：
     * 10 7 12 8 11 那么抹除掉的整数只可能是9
     * 5 6 7 8 那么抹除掉的整数可能是4也可能是9
     *
     * @param args
     */
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
