package lsf.other;

/**
 * @author scolphew
 */
public class 二维数组查找 {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 思路：从左下角或右上角开始，如果改点不等于要查找的值，就向对应的方向移动一行/一列
     *
     * @param target 要查找的数字
     * @param array  数组
     * @return 是否存你在该数字
     */
    public boolean Find(int target, int[][] array) {
        int m = array.length;
        int n = array[0].length;

        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}

