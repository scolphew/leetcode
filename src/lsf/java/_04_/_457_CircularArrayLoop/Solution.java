package lsf.java._04_._457_CircularArrayLoop;

public class Solution {

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            int y = i, c = 0, z;
            while (c < nums.length) {
                z = next(y, nums);
                if (z == y)
                    nums[y] = 0;
                if (nums[y] * nums[z] <= 0)
                    break;
                y = z;
                c++;
            }
            if (c == nums.length)
                return true;
            y = i;
            while (c > 0) {
                nums[y] = 0;
                c--;
            }
        }
        return false;
    }

    private int next(int x, int[] nums) {
        return (x + nums[x] + nums.length) % nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().circularArrayLoop(new int[]{1, 2, 3, -1, -2, -3}));
        System.out.println(new Solution().circularArrayLoop(new int[]{2, -1, 1, 2, 2}));

    }

}
