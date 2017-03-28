package other;

import java.util.Scanner;

/**
 * 两个字符串,找出其中最长的公共连续子串,输出其长度。
 * @author scolphew
 */
public class 最长连续公共字串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int l1 = s1.length();
        int l2 = s2.length();

        int[] nums = new int[l2 + 1];
        int tmp = 0;
        int max = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                int tmp1 = tmp;
                tmp = nums[j + 1];
                if (c1 == c2) {
                    nums[j + 1] = tmp1 + 1;
                    if (nums[j + 1] > max) {
                        max = nums[j + 1];
                    }
                } else {
                    nums[j + 1] = 0;
                }
            }
        }
        System.out.println(max);
    }
}
