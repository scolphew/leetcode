package lsf.java._07_._748_ShortestCompletingWord;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] a = count(licensePlate);

        String ans = null;

        o:
        for (String word : words) {
            int[] x = count(word);
            for (int i = 0; i < 26; i++) {
                if (x[i] < a[i])
                    continue o;
            }
            ans = (ans == null || ans.length() > word.length()) ? word : ans;

        }
        return ans;
    }

    private int[] count(String word) {
        int[] x = new int[26];
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') x[c - 'a']++;
            if (c >= 'A' && c <= 'Z') x[c - 'A']++;
        }
        return x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = new String[]{"looks", "pest", "stew", "show"};
        System.out.println(solution.shortestCompletingWord("1s3 456", s));
    }

}
