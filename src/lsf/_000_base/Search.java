package lsf._000_base;

/**
 * @author scolphew
 */
public class Search {

    /**
     * 二分查找
     */
    public static int search(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

}
