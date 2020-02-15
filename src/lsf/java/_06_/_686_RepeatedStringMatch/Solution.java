package lsf.java._06_._686_RepeatedStringMatch;

public class Solution {

    /**
     * 检查A串从index开始，是否和B串相同
     */
    public boolean check(int index, String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt((i + index) % A.length()) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，
     * 使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
     *
     * 举个例子，A = "abcd"，B = "cdabcdab"。
     *
     * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，
     * 此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
     *
     * 思路，
     * 将B哈希，把将a-zA-Z转换为59进制数字，计算出十进制对应数值，作为hash
     * 计算a前B位的hash，和b比较
     * 不同的话，删除a的第一位，在后加以为，计算hash，b进位
     */
    public int repeatedStringMatch(String A, String B) {
        //int q = (B.length() - 1) / A.length() + 1;  //向上取整
        int q = (int) Math.ceil(1.0 * B.length() / A.length());
        int p = 59;  // A=0 Z=25 a=32 z=57       按58进制计算
        int MOD = 10_0000_0007;

        long bHash = 0;// b的hash值
        long power = 1;
        for (int i = 0; i < B.length(); i++) {
            bHash += power * (B.charAt(i) - 64);
            bHash %= MOD;
            power = (power * p) % MOD;
        }

        long aHash = 0;
        power = 1;
        for (int i = 0; i < B.length(); i++) {
            aHash += power * (A.charAt(i % A.length()) - 64);
            aHash %= MOD;
            power = (power * p) % MOD;
        }

        if (aHash == bHash && check(0, A, B)) return q;

        long startPower = 1;

        for (int i = B.length(); i < (q + 1) * A.length(); i++) {
            bHash = (bHash * p) % MOD;

            // 先删除a的第一个
            int aChar = A.charAt((i - B.length()) % A.length()) - 64;
            long aHashDiff = (aChar * startPower) % MOD; // aHash减去的值
            aHash = aHash + MOD - aHashDiff;
            aHash %= MOD;
            startPower = (startPower * p) % MOD;

            aChar = A.charAt(i % A.length()) - 64;  // 在a后面添加一个
            aHashDiff = (aChar * power) % MOD;
            aHash += aHashDiff;
            aHash %= MOD;
            power = (power * p) % MOD;

            for (int j = 0; j < B.length(); j++) {
                System.out.print(A.charAt((i - B.length() + j) % A.length()));
            }
            System.out.println();


            if (aHash == bHash && check(i - B.length() + 1, A, B)) {
                return i < q * A.length() ? q : q + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.repeatedStringMatch("abcd", "cdabcdab"));
        //System.out.println(s.repeatedStringMatch("abcd", "abcdabcd"));
        System.out.println(s.repeatedStringMatch("aaabc", "bca"));
        System.out.println(s.repeatedStringMatch("caaaaaaaaaaab", "bca"));
    }

}
