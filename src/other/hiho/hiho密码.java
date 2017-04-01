package other.hiho;

import java.util.Scanner;

/**
 * @author scolphew
 */
public class hiho密码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        int tag = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] < nums[i - 1])
                tag = i;
        }

        System.out.print(nums[0]);
        for (int i = 1; i < tag; i++) {
            System.out.printf(" %d", nums[i]);
        }
    }
}
