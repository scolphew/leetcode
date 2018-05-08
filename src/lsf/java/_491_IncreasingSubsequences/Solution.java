package lsf.java._491_IncreasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        findSequence(set, list, 0, nums);
        return new ArrayList<>(set);
    }

    private void findSequence(Set<List<Integer>> set, List<Integer> list, int index, int[] nums) {
        if (list.size() >= 2) {
            set.add(new ArrayList(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                findSequence(set, list, i + 1, nums);
                list.remove(list.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{1, 2, 3, 4}));
    }

}
