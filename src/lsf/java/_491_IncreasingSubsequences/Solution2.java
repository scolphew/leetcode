package lsf.java._491_IncreasingSubsequences;

import java.util.*;

public class Solution2 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        return new ArrayList<>(findSubsequences(nums, 0, nums.length - 1));
    }

    public Set<List<Integer>> findSubsequences(int[] nums, int i, int j) {
        Set<List<Integer>> ans = new HashSet<>();
        if (i >= j)
            return ans;
        for (int k = i; k < j; k++) {
            if (nums[k] <= nums[j]) {
                ans.add(Arrays.asList(nums[k], nums[j]));
            }
        }
        for (List<Integer> l : findSubsequences(nums, i, j - 1)) {
            ans.add(l);
            if (nums[j] >= l.get(l.size() - 1)) {
                List<Integer> tmp = new ArrayList<>(l);
                tmp.add(nums[j]);
                ans.add(tmp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1}));
    }

}
