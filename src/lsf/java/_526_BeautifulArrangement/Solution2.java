package lsf.java._526_BeautifulArrangement;

public class Solution2 {

    int cnt = 0;

    public int countArrangement(int N) {
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        permutation(nums, 0);
        return cnt;
    }

    private void permutation(int[] nums, int sta) {
        if (sta == nums.length) {
            cnt++;
            return;
        }
        for (int i = sta; i < nums.length; i++) {
            swap(nums, sta, i);
            if (nums[sta] % (sta + 1) == 0 || (sta + 1) % nums[sta] == 0) {
                permutation(nums, sta + 1);
            }
            swap(nums, sta, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
