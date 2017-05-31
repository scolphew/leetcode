package lsf._373_FindKPairswithSmallestSums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    class Pair {
        int[] nums;
        int index;

        Pair(int a, int b, int index) {
            nums = new int[]{a, b};
            this.index = index;
        }
    }


    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> que = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.nums[0] + o1.nums[1] - o2.nums[0] - o2.nums[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;
        for (int i = 0; i < nums1.length && i < k; i++)
            que.offer(new Pair(nums1[i], nums2[0], 0));
        while (k-- > 0 && !que.isEmpty()) {
            Pair cur = que.poll();
            res.add(cur.nums);
            if (cur.index == nums2.length - 1) continue;
            que.offer(new Pair(cur.nums[0], nums2[cur.index + 1], cur.index + 1));
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
