package lsf.java._00_._033_SearchinRotatedSortedArray;

/**
 * 有序数组被随机左移未知位
 * 查找指定的值
 *
 * @author scolphew
 */
public class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target)
                return mid;
            // 左半边有序
            if (nums[left] <= nums[mid]) {
                // tag在左半边
                if (target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            //右半边有序
            else {
                // tag在右半边
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] i = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};

        System.out.println(s.search(i, 7));

    }

}
