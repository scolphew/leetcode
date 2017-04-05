package other.其他;

import java.util.Scanner;

/**
 * 平衡数的定义是：将一个数分成左右两部分，分别成为两个新的数。
 * 左右部分必须满足以下两点：
 * 1，左边和右边至少存在一位。
 * 2，左边的数每一位相乘如果等于右边的数每一位相乘，则这个数称为平衡数。
 * 例如：1221这个数，分成12和21的话，1*2=2*1，则称1221为平衡数，
 * 再例如：1236这个数，可以分成123和1*2*3=6，所以1236也是平衡数。
 * 而1234无论怎样分也不满足平衡数。
 *
 * @author scolphew
 */
public class 平衡数 {
    public static boolean check(int num) {
        if (num < 10)
            return false;
        char[] chars = (new Integer(num).toString()).toCharArray();
        int[] nums = new int[chars.length];
        int count0 = 0;
        for (int i = 0; i < chars.length; i++) {
            int j = chars[i] - '0';
            nums[i] = j;
            if (j == 0)
                if (count0 == 0)
                    count0 += 1;
                else
                    return true;
        }
        int i = 0, j = chars.length - 1;
        int left = 1, right = 1;
        while (i <= j) {
            if (left > right) {
                right *= nums[j--];
            } else {
                left *= nums[i++];
            }
        }
        return left == right;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = check(in.nextInt()) ? "YES" : "NO";
            System.out.println(s);
        }
    }
}
