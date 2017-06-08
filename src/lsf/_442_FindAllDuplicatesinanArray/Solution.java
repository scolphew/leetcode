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

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new Solution().findDuplicates(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7}));
    }
}
