package lsf._215_KthLargestElementinanArray;

public class Solution {
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

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 1, 2, 4};
        //for (int i = 1; i < nums.length + 1; i++) {
        //    System.out.println(s.findKthLargest(nums, i));
        //}
        System.out.println(s.findKthLargest(nums, 2));
    }
}
