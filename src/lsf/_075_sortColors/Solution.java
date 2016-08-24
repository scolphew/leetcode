package lsf._075_sortColors;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		int a[] = { 0, 0, 1, 1, 2, 1, 2 };
		s.sortColors(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	// Given an array with n objects colored red, white or blue, sort them so
	// that objects of the same color are adjacent, with the colors in the order
	// red, white and blue.
	// 考虑到与红色，白色或蓝色的n个对象数组，对它们进行排序，使相同颜色的对象是相邻的，与颜色的顺序红色，白色和蓝色。
	// Here, we will use the integers 0, 1, and 2 to represent the color red,
	// white, and blue respectively.
	//
	// 在这里，我们将使用整数0，1和2分别表示红色，白色和蓝色。
	// Note:
	// You are not suppose to use the library's sort function for this problem.
	// 你是不是想利用图书馆的排序功能，对于这个问题。
	// click to show follow up.
	public void sortColors(int[] nums) {
		int red = 0, white = 0, blue = 0;
		//顺序检索 计数
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				red++;
			else if (nums[i] == 1)
				white++;
			else if (nums[i] == 2)
				blue++;
		}
		int i = 0;
		while (red-- > 0)
			nums[i++] = 0;
		while (white-- > 0)
			nums[i++] = 1;
		while (blue-- > 0)
			nums[i++] = 2;
	}
}
