package base;

public class Diff {

    /**
     * 两个int数组是否相同
     */
    public static boolean diff(int[] a, int[] b) {
        if (a.length != b.length)
            return true;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return true;
        }
        return false;
    }

}
