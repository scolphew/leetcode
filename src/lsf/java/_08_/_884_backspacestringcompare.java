package lsf.java._08_;

public class _884_backspacestringcompare {

    /**
     * 844. 比较含退格的字符串
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     */
    public boolean backspaceCompare(String S, String T) {
        char[] s1 = S.toCharArray();
        char[] s2 = T.toCharArray();
        int i = s1.length - 1, j = s2.length - 1;
        while (i >= 0 && j >= 0) {
            i = help(s1, i);
            j = help(s2, j);
            if (i < 0 || j < 0)
                break;
            if (s1[i] != s2[j])
                return false;
            i--;
            j--;
        }
        i = help(s1, i);
        j = help(s2, j);
        return i == -1 && j == -1;

    }

    public int help(char[] chars, int i) {
        int tmp = 0;
        while (i >= 0 && (tmp > 0 || chars[i] == '#')) {
            if (tmp > 0)
                if (chars[i] == '#')
                    tmp++;
                else
                    tmp--;
            else
                tmp++;
            i--;
        }
        return i;
    }


}
