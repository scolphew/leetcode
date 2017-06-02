package lsf._387_FirstUniqueCharacterinaString;

public class Solution {
    public int firstUniqChar(String s) {
        int[] index = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            index[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (index[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
