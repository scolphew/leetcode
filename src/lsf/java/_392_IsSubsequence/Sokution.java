package lsf.java._392_IsSubsequence;

public class Sokution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int index = 0;
        char[] ss = s.toCharArray();

        for (char c : t.toCharArray()) {
            if (c == ss[index]) {
                index++;
                if (index == ss.length)
                    return true;
            }
        }
        return false;
    }
}
