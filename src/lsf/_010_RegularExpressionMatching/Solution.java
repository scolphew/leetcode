package lsf._010_RegularExpressionMatching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author scolphew
 */
public class Solution {

    Solution s;

    public boolean isMatch(String s, String p) {
        if (s.equals(p))
            return true;
        if (s == null || p == null)
            return false;

        int s_len = s.length();
        int p_len = p.length();

        boolean[][] flag = new boolean[s_len + 1][p_len + 1];

        flag[0][0] = true;
        for (int i = 0; i < p_len; i++) {
            if(p.charAt(i) == '*')
                flag[0][i+1] = flag[0][i-1];
        }

        for (int i = 1; i <= s_len; i++) {
            for (int j = 1; j <= p_len; j++) {
                char s_char = s.charAt(i);
                char p_char = p.charAt(j);

                if (p_char == '.' || s_char == p_char)
                    flag[i][j] = flag[i - 1][j - 1];


                else if (p_char == '*') {
                    if (flag[i-1][j-2] || flag[i - 1][j-1])
                        flag[i][j] = true;
                    else if(p.charAt(j-1)=='.' || p.charAt(j-1)==s_char)
                        flag[i][j] = flag[i-1][j];
                }
            }
        }

        return flag[s_len][p_len];
    }

    @Test
    public void t() {
    }

    @Test
    public void t0() {
        Assert.assertEquals(s.isMatch("aa", "a"), false);
    }

    @Test
    public void t1() {
        Assert.assertEquals(s.isMatch("aa", "aa"), true);
        Assert.assertEquals(s.isMatch("ab", ".*"), true);
    }

    @Test
    public void t2() {
        Assert.assertEquals(s.isMatch("aa", "a*"), true);
    }

    @Test
    public void t3() {
        Assert.assertEquals(s.isMatch("aa", "a."), true);
    }

    @Test
    public void t4() {
        Assert.assertEquals(s.isMatch("aa", ".*"), true);
    }

    @Test
    public void t5() {
        Assert.assertEquals(s.isMatch("aa", ".."), true);
    }

    @Test
    public void t6() {
        Assert.assertEquals(s.isMatch("aaa", "a*a"), true);
    }

    @Before
    public void before() {
        s = new Solution();
    }
}
