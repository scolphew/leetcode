package other.其他;

import base.Print;

public class 字符串重复 {

    /**
     * 求字符串是否由相同的字符串拼接而成的
     *
     * @param s
     */
    public boolean idRepeat(String s) {

        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < n; i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        Print.print(next);
        int lenSub = n - 1 - next[n - 1];
        return lenSub != n && n % lenSub == 0;
    }


    public static void main(String[] args) {
        字符串重复 s = new 字符串重复();
        System.out.println(s.idRepeat("abcde"));
        System.out.println(s.idRepeat("ababababab"));
    }

}
