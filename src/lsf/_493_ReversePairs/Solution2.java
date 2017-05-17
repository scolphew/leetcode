package lsf._493_ReversePairs;

public class Solution2 {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private int merge(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int mid = s + (e - s) / 2;
        int cnt = merge(nums, s, mid) + merge(nums, mid + 1, e);
        int tmp[] = new int[e - s + 1];
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j])
                j++;
            cnt += j - mid - 1;
        }
        int i = s, j = mid + 1, index = 0;
        while (i <= mid && j <= e) {
            if (nums[i] < nums[j])
                tmp[index++] = nums[i++];
            else
                tmp[index++] = nums[j++];
        }
        while (i <= mid)
            tmp[index++] = nums[i++];
        while (j <= e)
            tmp[index++] = nums[j++];
        System.arraycopy(tmp, 0, nums, s, tmp.length);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().reversePairs(new int[]{1, 4, 3, 6, 5, 8, 6, 9, 2, 4}));
    }


}
