package lsf._371_SumofTwoIntegers;

public class Solution {
    public int getSum(int a, int b) {
        //return a ^ b + (a & b) << 1;
        int jg = a ^ b;
        int jw = a & b;
        while (jw != 0) {
            int t_a = jg;
            int t_b = jw << 1;
            jg = t_a ^ t_b;
            jw = t_a & t_b;
        }
        return jg;
    }
}
