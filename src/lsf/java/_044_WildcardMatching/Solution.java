package lsf.java._044_WildcardMatching;

/**
 * 字符串匹配 （ ？ * ）
 *
 * @author scolphew
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals(p))
            return true;
        if (s == null || p == null)
            return false;

        int s_len = s.length();
        int p_len = p.length();

        boolean[][] flag = new boolean[s_len + 1][p_len + 1];
        flag[0][0]=true;
        for (int i = 0; i < p_len; i++) {
            if(p.charAt(i)=='*')
                flag[0][i+1]=flag[0][i];
        }

        for (int i = 1; i <= s_len; i++) {
            for (int j = 1; j <= p_len; j++) {
                char s_char = s.charAt(i - 1);
                char p_char = p.charAt(j - 1);
                if (p_char == '?' || s_char == p_char)
                    flag[i][j] = flag[i - 1][j - 1];
                else if (p_char == '*') {
                    if (flag[i][j - 1])
                        flag[i][j] = true;
                    if (flag[i - 1][j - 1])
                        flag[i][j] = true;
                    if(flag[i-1][j])
                        flag[i][j]=true;
                }
            }
        }
        return flag[s_len][p_len];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(false == s.isMatch("aa", "a"));
        System.out.println(true == s.isMatch("aa", "aa"));
        System.out.println(false == s.isMatch("aaa", "aa"));
        System.out.println(true == s.isMatch("aa", "*"));
        System.out.println(true == s.isMatch("aa", "a*"));
        System.out.println(true == s.isMatch("ab", "?*"));
        System.out.println(false == s.isMatch("aab", "c*a*b"));
    }
}
