package lsf.java._07_._779_KthSymbolinGrammar;

public class Solution {

    //在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
    //给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
    public int kthGrammar(int N, int K) {
        int ans = 0;

        while (N >= 0) {
            if (K > 1 << N) {
                K -= 1 << N;
                ans = 1 - ans;
            }
            N--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.kthGrammar(2, 1));
        System.out.println(s.kthGrammar(2, 2));
        System.out.println(s.kthGrammar(2, 3));
        System.out.println(s.kthGrammar(2, 4));
        System.out.println(s.kthGrammar(2, 5));
        System.out.println(s.kthGrammar(2, 6));
        System.out.println(s.kthGrammar(2, 7));
        System.out.println(s.kthGrammar(2, 8));
        System.out.println(s.kthGrammar(2, 9));
        System.out.println(s.kthGrammar(3, 10));
    }

}
