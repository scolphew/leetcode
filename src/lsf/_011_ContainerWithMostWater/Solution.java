package lsf._011_ContainerWithMostWater;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * @author scolphew
 */
public class Solution {

    /**
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        //if (height.length == 2)
        //    return Math.min(height[0], height[1]);
        int maxArea = 0, area;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int l_num = height[i];
            int r_num = height[j];
            if (l_num > r_num) {
                area = (j - i) * r_num;
                while (height[--j] <= r_num);
            } else {
                area = (j - i) * l_num;
                while (height[++i] < l_num);
            }
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int area = s.maxArea(new int[]{1,1});
        System.out.println(area);
    }
}
