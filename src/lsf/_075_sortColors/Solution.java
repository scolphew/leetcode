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
	// ���ǵ����ɫ����ɫ����ɫ��n���������飬�����ǽ�������ʹ��ͬ��ɫ�Ķ��������ڵģ�����ɫ��˳���ɫ����ɫ����ɫ��
	// Here, we will use the integers 0, 1, and 2 to represent the color red,
	// white, and blue respectively.
	//
	// ��������ǽ�ʹ������0��1��2�ֱ��ʾ��ɫ����ɫ����ɫ��
	// Note:
	// You are not suppose to use the library's sort function for this problem.
	// ���ǲ���������ͼ��ݵ������ܣ�����������⡣
	// click to show follow up.
	public void sortColors(int[] nums) {
		int red = 0, white = 0, blue = 0;
		//˳����� ����
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
