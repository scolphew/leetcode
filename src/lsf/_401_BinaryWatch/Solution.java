package lsf._401_BinaryWatch;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            for (Integer h : nNitIntWithKOnt(4, i))
                if (h < 12)
                    for (Integer m : nNitIntWithKOnt(6, num - i))
                        if (m < 60)
                            ans.add(String.format("%d:%02d", h, m));
        }
        return ans;
    }

    /**
     * 含有k个1的n位数
     *
     * @return
     */
    public List<Integer> nNitIntWithKOnt(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        if (k == 0) {
            ans.add(0);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            int t = 1 << i;
            for (int tmp : nNitIntWithKOnt(i, k - 1))
                ans.add(t + tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
    }


}
