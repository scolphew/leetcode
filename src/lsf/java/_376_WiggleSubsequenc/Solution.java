package lsf.java._376_WiggleSubsequenc;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int ans = 1;//默认至少一个
        int k = 0;
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) k++;// 截取开始平滑的部分
        if (k == nums.length - 1) return ans;  //恒定数列
        boolean flag = nums[k] > nums[k + 1];//方向标记，true递增，初始值为前两个的相反方向
        for (int i = k + 1; i < nums.length; i++) {
            if ((flag != nums[i - 1] < nums[i]) && nums[i - 1] != nums[i]) {//如果i-1,i的方向和之前不同则增加一节
                flag = !flag;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(new Solution().wiggleMaxLength(new int[]{2, 1, 2}));
    }
}
