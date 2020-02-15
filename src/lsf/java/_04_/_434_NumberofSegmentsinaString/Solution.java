package lsf.java._04_._434_NumberofSegmentsinaString;

public class Solution {
    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                res++;
        return res;
    }

    public static void main(String[] args) {
        String s = "!23";
        int ans = ("x " + s).split(" +").length - 1;
    }
}
