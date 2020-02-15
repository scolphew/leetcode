package lsf.java._06_._640_SolvetheEquation;

public class Solution {

    public int foo(String s) {
        return (s.equals("x") || s.equals("+x")) ? 1 : s.equals("-x") ? -1 : Integer.parseInt(s.replace("x", ""));

    }

    /**
     * 解一元一次方程
     */
    public String solveEquation(String equation) {
        String[] lr = equation.split("=");
        String[] left = lr[0].split("(?=[+-])");
        String[] right = lr[1].split("(?=[+-])");

        int l = 0, r = 0;
        for (String s : left) {
            if (s.indexOf('x') >= 0) {
                l += foo(s);
            } else {
                r -= Integer.parseInt(s);
            }
        }

        for (String s : right) {
            if (s.indexOf('x') >= 0) {
                l -= foo(s);
            } else {
                r += Integer.parseInt(s);
            }
        }

        if (l == 0) {
            return r == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + r / l;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solveEquation("x+5-3+x=6+x-2"));
    }

}
