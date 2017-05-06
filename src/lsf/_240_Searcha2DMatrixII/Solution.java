package lsf._240_Searcha2DMatrixII;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = 0;
        int m = matrix[0].length - 1;


        while (n < matrix.length && m >= 0) {
            if (matrix[n][m] > target) {
                m--;
            } else if (matrix[n][m] < target) {
                n++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19}
                },
                5));
    }
}
