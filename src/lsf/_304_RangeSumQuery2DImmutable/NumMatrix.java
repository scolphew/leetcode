package lsf._304_RangeSumQuery2DImmutable;

public class NumMatrix {

    int[][] data;

    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0)
            data = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                data[i + 1][j + 1] = matrix[i][j] + data[i + 1][j] + data[i][j + 1] - data[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return data[row2 + 1][col2 + 1] - data[row1][col2 + 1] - data[row2 + 1][col1] + data[row1][col1];
    }
}
