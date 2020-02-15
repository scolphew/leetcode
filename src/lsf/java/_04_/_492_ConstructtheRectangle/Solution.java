package lsf.java._04_._492_ConstructtheRectangle;

public class Solution {

    public int[] constructRectangle(int area) {
        int m = (int) Math.sqrt(area);
        while (m > 0) {
            if (area % m == 0) {
                return new int[]{area / m, m};
            }
        }
        return null;
    }

}
