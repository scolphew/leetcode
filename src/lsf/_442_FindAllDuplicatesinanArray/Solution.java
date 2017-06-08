package lsf._442_FindAllDuplicatesinanArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1 && nums[i] != i + 1) {
                int tmp = nums[i];
                nums[i] = -1;
                while (tmp > 0 && nums[tmp - 1] != tmp) {
                    int t = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                    tmp = t;
                }
                if (tmp != -1)
                    nums[i] = -1;
                if (tmp > 0)
                    ans.add(tmp);
            }
        }
        return ans;
    }


    public List<Integer> foo(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length) {
                int originalNumber = nums[i] - nums.length;
                if (originalNumber <= nums.length)
                    nums[originalNumber - 1] += nums.length;
                else
                    nums[originalNumber - nums.length - 1] += nums.length;
            } else {
                nums[nums[i] - 1] += nums.length;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= (2 * nums.length);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                duplicates.add(i + 1);
        }
        return duplicates;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().foo(new int[]{4, 7, 8, 2, 3, 2, 3, 1}));
        System.out.println(new Solution().findDuplicates(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7}));
    }
}
