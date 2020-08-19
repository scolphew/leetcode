package lsf.java._07_._768_MaxChunksToMakeSortedII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> count = new HashMap();
        int ans = 0, nonzero = 0;//统计这个块的所有数归零的数量

        int[] expect = arr.clone();
        Arrays.sort(expect);

        for (int i = 0; i < arr.length; ++i) {
            int x = arr[i], y = expect[i];

            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 0) nonzero--;   //如果原本是负的，变成0了，说明这个数计数归零
            if (count.get(x) == 1) nonzero++;   //如果原本从0变成1，增加一个计数

            count.put(y, count.getOrDefault(y, 0) - 1);
            if (count.get(y) == -1) nonzero++;
            if (count.get(y) == 0) nonzero--;

            if (nonzero == 0) ans++;
        }

        return ans;

    }


    private int max(int[] nums, int f, int t, int n) {
        int ans = n;
        for (int i = f; i <= t; i++) {
            if (nums[i] > ans)
                ans = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxChunksToSorted(new int[]{3, 3, 0, 0}));
        System.out.println(s.maxChunksToSorted(new int[]{2, 1, 2, 1, 2, 1, 3, 4, 4}) == 4);
        System.out.println(s.maxChunksToSorted(new int[]{1, 1, 1, 2, 2, 2}) == 6);
        System.out.println(s.maxChunksToSorted(new int[]{5, 4, 3, 2, 1}) == 1);
        System.out.println(s.maxChunksToSorted(new int[]{1, 0, 1, 3, 2}) == 3);
        System.out.println(s.maxChunksToSorted(new int[]{0, 3, 0, 3, 2}) == 2);
        System.out.println(s.maxChunksToSorted(new int[]{1, 2, 4, 2, 2}) == 3);
        System.out.println(s.maxChunksToSorted(new int[]{4, 3, 2, 1, 3, 3}) == 1);

    }

}
