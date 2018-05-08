package lsf.java._011_ContainerWithMostWater;

/**
 * 给平行于y轴的n条线段的高度
 * 求任意两个线段和x轴围成矩形的最大面积
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
