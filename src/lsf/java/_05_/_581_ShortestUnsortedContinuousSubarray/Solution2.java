package lsf.java._05_._581_ShortestUnsortedContinuousSubarray;

public class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < len - 1 && nums[left] <= nums[left + 1]) left++;// 找到数组从头开始有序的部分
        if (left == len - 1) return 0;//如果全部有序
        while (right > left && nums[right - 1] <= nums[right]) right--;//找到数组后半部分有序的部分
        int min = nums[left], max = nums[left]; //找到中间部分的最大最小值
        for (int i = left; i <= right; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        int i = 0, j = len - 1;
        while (i <= left && nums[i] <= min) i++; //大于最小值的起点
        while (j >= right && nums[j] >= max) j--;//小于最大值的重点
        return j - i + 1;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution2().findUnsortedSubarray(new int[]{1, 3, 4, 2, 5, 8, 6, 7, 9}));
        System.out.println(new Solution2().findUnsortedSubarray(new int[]{1, 2, 3, 4, 5, 6, 7}));
        //System.out.println(new Solution2().findUnsortedSubarray(new int[]{1, 2, 3, 4, 5, 6, 7, 6}));
        System.out.println(new Solution2().findUnsortedSubarray(new int[]{1, 2, 3, 4, 5, 6, 7, 6, 8, 9}));
        System.out.println(new Solution2().findUnsortedSubarray(new int[]{1, 2, 3, 4, 5, 6, 7, 5, 6, 4, 7, 4, 6, 8, 9}));
    }
}
