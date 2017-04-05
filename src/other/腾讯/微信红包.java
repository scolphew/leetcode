package other.腾讯;

/**
 * @author scolphew
 */
public class 微信红包 {
    public int getValue(int[] gifts, int n) {
        if (n == 0) {
            return 0;
        }
        int pre = gifts[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (gifts[i] == pre) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    pre = gifts[i];
                }
            }
        }
        return count > 0 ? pre : 0;

    }
}
