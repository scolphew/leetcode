package other.练习;

import java.util.Scanner;

/**
 * 鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)
 * 把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。
 * 一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B
 * 需要保证：
 * 1、放进去的鱼是安全的，不会被其他鱼吃掉
 * 2、这条鱼放进去也不能吃掉其他鱼
 * 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。
 * 现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示),
 * 有多少种大小的鱼可以放入这个鱼缸。
 *
 * @author scolphew
 */
public class 大鱼吃小鱼 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int minSize = in.nextInt();
        int maxSize = in.nextInt();
        int n = in.nextInt();
        int[] fishSize = new int[n];
        for (int i = 0; i < n; i++) {
            fishSize[i] = in.nextInt();
        }
        int count = 0;
        for (int i = minSize; i <= maxSize; i++) {
            boolean canEat = false;
            for (int j : fishSize) {
                if (i * 2 >= j && i * 10 <= j) {
                    canEat = true;
                    break;
                } else if (j * 2 >= i && j * 10 <= i) {
                    canEat = true;
                    break;
                }
            }
            if (!canEat)
                count++;
        }
        System.out.println(count);

    }

}
