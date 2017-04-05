//package other.网易;
//
//import java.util.Scanner;
//
//public class 最大和 {
//    /**
//     * 在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，
//     * 四种方向的直线连续D个数字的和里面最大的值
//     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int d = in.nextInt();
//        int nums[][] = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                nums[i][j] = in.nextInt();
//            }
//        }
//
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            int sum =
//            for (int j = 1; j < n; j++) {
//                int sum = nums[i][j - 1] + nums[i][j];
//                if (sum > max)
//                    max = sum;
//            }
//        }
//        for (int i = 1; i < n; i++) {
//            int sum = nums[i - 1][i - 1] + nums[i][i];
//            if (sum > max)
//                max = sum;
//            sum = nums[n - 1 - i][i] + nums[n - i][i - 1];
//            if (sum > max)
//                max = sum;
//        }
//        System.out.println(max);
//    }
//}
