package lsf.java._229_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int n = nums.length;
        int a1 = nums[0], a2 = nums[0], c1 = 0, c2 = 0;

        for (int i : nums) {
            if (i == a1)
                c1++;
            else if (i == a2)
                c2++;
            else if (c1 == 0) {
                a1 = i;
                c1 = 1;
            } else if (c2 == 0) {
                a2 = i;
                c2 = 1;
            } else {
                --c1;
                --c2;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (i == a1)
                c1++;
            else if (i == a2)
                c2++;
        }
        if (c1 > n / 3)
            ans.add(a1);
        if (c2 > n / 3)
            ans.add(a2);
        return ans;
    }

    public static void main(String[] args) {
    }
}
