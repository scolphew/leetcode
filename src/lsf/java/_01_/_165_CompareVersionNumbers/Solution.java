package lsf.java._01_._165_CompareVersionNumbers;

public class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int v1 = 0, v2 = 0;
            char c1, c2;
            while (i < version1.length() && (c1 = version1.charAt(i++)) != '.')
                v1 = v1 * 10 + c1 - '0';
            while (j < version2.length() && (c2 = version2.charAt(j++)) != '.')
                v2 = v2 * 10 + c2 - '0';
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.1.1", "1.1.1.0"));
        System.out.println(new Solution().compareVersion("1", "1.1"));
    }
}
