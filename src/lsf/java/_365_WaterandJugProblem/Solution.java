package lsf.java._365_WaterandJugProblem;

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 1) {
            if (a % b == 0) return b;
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(0, 0, 1));
    }
}
