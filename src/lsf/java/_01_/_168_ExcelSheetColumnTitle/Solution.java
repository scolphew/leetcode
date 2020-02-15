package lsf.java._01_._168_ExcelSheetColumnTitle;

public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }

    public String convertToTitle2(int n) {
        StringBuilder sb = new StringBuilder();
        char c;
        while (n > 0) {
            c = (char) (((--n) % 26) + 'A');
            sb.insert(0, c);
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle2(26));
    }
}
