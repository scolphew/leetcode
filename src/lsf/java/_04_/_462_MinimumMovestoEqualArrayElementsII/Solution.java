package lsf.java._04_._462_MinimumMovestoEqualArrayElementsII;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minMoves2(new int[]{1, 2, 3}));
    }

    public int minMoves2(int[] nums) {

        int n = findKthLargest(nums, (nums.length + 1) / 2);
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - n);
        }
        return ans;
    }


    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, nums.length - k);
    }

    public int find(int[] nums, int l, int r, int i) {
        while (l < r) {
            int mid = foo(nums, l, r);
            if (mid == i)
                return nums[i];
            if (mid > i)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return nums[l];
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void random(int[] nums, int i, int j) {
        int tmp = i + (int) (Math.random() * (j - i));
        swap(nums, tmp, i);
    }

    public int foo(int[] nums, int l, int r) {
        random(nums, l, r);
        int i = l, j = l + 1;
        while (j <= r) {
            if (j != l && nums[j] < nums[l]) {
                swap(nums, ++i, j);
            }
            ++j;
        }
        swap(nums, i, l);
        return i;
    }


}
