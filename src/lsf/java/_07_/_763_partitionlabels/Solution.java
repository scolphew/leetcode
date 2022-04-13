package lsf.java._07_._763_partitionlabels;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
     */
    public List<Integer> partitionLabels(String S) {
        int[] ids = new int[26];
        char[] s = S.toCharArray();

        for (int i = 0; i < s.length; i++) {
            ids[s[i] - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();

        int first = 0;
        int last = ids[s[0] - 'a'];
        for (int i = 1; i < s.length; i++) {
            if (last < i) {
                ans.add(i - first);
                first = i;
                last = ids[s[i] - 'a'];
            } else {
                last = Math.max(last, ids[s[i] - 'a']);
            }
        }
        ans.add(s.length - first);
        return ans;

    }
}
