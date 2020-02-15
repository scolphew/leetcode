package lsf.java._04_._482_LicenseKeyFormatting;

public class Solution {

    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        int firstLength = S.length() % K;
        StringBuilder sb = new StringBuilder(S);
        int nIndex = firstLength;
        if (firstLength == 0) {
            nIndex = K;
        }
        while (nIndex < sb.length()) {
            sb.insert(nIndex, '-');
            nIndex += K + 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("adc123-123", 4));
    }
}

