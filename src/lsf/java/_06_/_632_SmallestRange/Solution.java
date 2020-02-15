package lsf.java._06_._632_SmallestRange;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    class Pair {
        int num;
        int group;

        public Pair(int x, int y) {
            num = x;
            group = y;
        }
    }

    /**
     * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
     * <p>
     * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        // 最小优先队列，
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.num));
        //数列的数量
        int size = nums.size();
        // 当前每个数列遍历的位置
        int[] ids = new int[size];
        //最大值
        int max = Integer.MIN_VALUE;
        // 依次把每一个数列的首位放入优先队列，并找到最大的值
        for (int i = 0; i < size; i++) {
            int num = nums.get(i).get(0);
            pq.add(new Pair(num, i));
            max = Math.max(max, num);
        }
        int start = -1, end = -1, gap = Integer.MAX_VALUE;

        while (pq.size() == size) {
            // 每次循环
            // 先去除最小值
            Pair p = pq.poll();
            int min = p.num, group = p.group;
            if (max - min < gap) {
                // 更小的区间，优先队列可以保证如果区间大小相等，后来的起始比之前的大
                start = min;
                end = max;
                gap = max - min;
            }
            //只要有任何一个结束就算结束
            if (++ids[group] < nums.get(group).size()) {
                p.num = nums.get(group).get(ids[group]);
                pq.add(p);
                max = Math.max(max, p.num);
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = s.smallestRange(Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(4)
        ));
        System.out.println(x[0]);
        System.out.println(x[1]);
    }

}
