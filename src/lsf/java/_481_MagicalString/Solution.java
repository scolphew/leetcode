package lsf.java._481_MagicalString;

public class Solution {

    public int magicalString(int n) {
        if (n <= 0)
            return 0;
        if (n <= 3)
            return 1;
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        int i = 3, j = 2;
        int nextNum = 1;
        int ans = 1;
        while (i < n) {
            for (int k = 0; k < a[j] && i < n; k++) {
                if (nextNum == 1)
                    ans++;
                a[i++] = nextNum;
            }
            nextNum = 3 - nextNum;
            j++;
        }
        //Print.print(a);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().magicalString(4));
    }

}
