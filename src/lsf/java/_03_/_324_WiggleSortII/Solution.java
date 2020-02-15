package lsf.java._03_._324_WiggleSortII;

import base.Print;

public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
        Print.print(nums);
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
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

    public static void main(String[] args) {
        Solution s = new Solution();
        s.wiggleSort(new int[]{0, 1, 2, 3, 4, 5});
    }

}
