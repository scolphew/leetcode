package other.其他;

import java.util.Scanner;

/**
 * N根木棒,分别编号为1~N,现在从N根里想取出三根木棒，
 * 使得三根木棒构成一个三角形,
 * 计算出有多少种取法吗?(考虑两种取法中使用的木棒编号有一个不一样就认为是不同的取法)。
 * @author scolphew
 */
public class 三角形 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        String s[] = str.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int a, b, c, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    a = nums[i];
                    b = nums[j];
                } else {
                    a = nums[j];
                    b = nums[i];
                }
                for (int k = j + 1; k < n; k++) {
                    int a1 = a;
                    if (nums[k] > a) {
                        c = a;
                        a = nums[k];
                    } else {
                        c = nums[k];
                    }
                    if (b + c > a)
                        res += 1;
                    a = a1;
                }
            }
        }
        System.out.println(res);
    }
}
