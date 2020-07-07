package lsf.java._07_._744_FindSmallestLetterGreaterThanTarget;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return letters[l] <= target ? letters[0] : letters[r];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }
}
