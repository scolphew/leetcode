package lsf.java._223_RectangleArea;

public class Solution {

    /**
     * 求两个矩形相交的面积
     * abcd  左下角 右上角坐标
     *
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l = A > E ? A : E;
        int r = C < G ? C : G;
        int d = B > F ? B : F;
        int t = D < H ? D : H;
        int ans = (C - A) * (D - B) + (G - E) * (H - F);

        if (r > l && t > d) {
            ans -= (t - d) * (r - l);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }
}
