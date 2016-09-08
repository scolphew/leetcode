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
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i<j){
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int area = s.maxArea(new int[]{2,1,3});
        System.out.println(area);
    }
}
