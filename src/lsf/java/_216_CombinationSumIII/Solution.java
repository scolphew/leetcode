package lsf.java._216_CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        foo(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    public void foo(List<List<Integer>> ans, List<Integer> pre, int start, int k, int n) {
        if (k == 1) {
            if (start <= n && n <= 9) {
                List<Integer> tmp = new ArrayList<>(pre);
                tmp.add(n);
                ans.add(tmp);
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            List<Integer> tmp = new ArrayList<>(pre);
            tmp.add(i);
            foo(ans, tmp, i + 1, k - 1, n - i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
    }

}
