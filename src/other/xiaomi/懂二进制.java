package other.xiaomi;

/**
 * @author scolphew
 */
public class 懂二进制 {
    public int countBitDiff(int m, int n) {
        int k = m ^ n;
        int res = 0;
        while (k > 0) {
            res += k & 1;
            k >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        懂二进制 s = new 懂二进制();
        int c = s.countBitDiff(1999, 2299);
        System.out.println(c);
    }
}
