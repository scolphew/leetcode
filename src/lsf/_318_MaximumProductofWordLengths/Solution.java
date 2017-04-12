package lsf._318_MaximumProductofWordLengths;

public class Solution {
    /**
     * 求max(len(i)*len(j)) where word i and word j 没有相同单词
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0 && words[i].length() * words[j].length() > res) {
                    res = words[i].length() * words[j].length();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProduct(new String[]{"abce", "qw"}));;
    }
}
