package lsf._042_TrappingRainWater;

/**
 * 一个数组代表了某地的海拔高度
 * 计算下雨后的积水量
 *
 * @author scolphew
 */
public class Solution {

    public int trap(int[] height) {
        if (height.length < 3)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int leftMax = height[left++];
        int rightMax = height[right--];

        while (left <= right) {
            if (leftMax > rightMax) {
                if (rightMax > height[right])
                    water += rightMax - height[right];
                else
                    rightMax = height[right];
                right--;
            } else {
                if (leftMax > height[left])
                    water += leftMax - height[left];
                else
                    leftMax = height[left];
                left++;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] i = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(s.trap(i));
    }
}
