package lsf.java._05_._520_DetectCapital;

public class Solution {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 0)
            return true;
        char[] w = word.toCharArray();


        if (w[0] >= 'a' && w[0] <= 'z') {
            for (int i = 1; i < w.length; i++) {
                if (w[i] < 'a' || w[i] > 'z')
                    return false;
            }
            return true;
        }

        if (w[0] >= 'A' && w[0] <= 'Z') {
            if (w.length == 1)
                return true;
            if (w[1] >= 'A' && w[1] <= 'Z') {
                for (int i = 2; i < w.length; i++) {
                    if (w[i] < 'A' || w[i] > 'Z')
                        return false;
                }
                return true;
            }
            if (w[1] >= 'a' && w[1] <= 'z') {
                for (int i = 2; i < w.length; i++) {
                    if (w[i] < 'a' || w[i] > 'z')
                        return false;
                }
                return true;
            }
            return false;


        }
        return false;
    }

}
