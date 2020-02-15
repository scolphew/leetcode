package lsf.java._04_._448_FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                nums[nums[i] - 1] += n;
            } else {
                int odd_ = nums[i] - n;
                if (odd_ <= n) {
                    nums[odd_ - 1] += n;
                } else {
                    nums[odd_ - 1 - n] += n;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] -= 2 * n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= -n) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new Solution().findDisappearedNumbers(new int[]{4, 3, 2, 7, 7, 2, 3, 1}));
    }

}
