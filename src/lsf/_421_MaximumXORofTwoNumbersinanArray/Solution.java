package lsf._421_MaximumXORofTwoNumbersinanArray;

public class Solution {

    class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[2];
        }

        void insert(int num) {
            Trie p = this;
            for (int j = 31; j >= 0; j--) {
                int curr = (num >>> j) & 1;
                if (p.children[curr] == null)
                    p.children[curr] = new Trie();
                p = p.children[curr];
            }
        }

        int fondMaxOr(int num) {
            int ans = 0;
            Trie p = this;
            for (int i = 31; i >= 0; i--) {
                int curr = (num >>> i) & 1;
                if (p.children[1 - curr] != null) {
                    ans += (1 << i);
                    p = p.children[1 - curr];
                } else {
                    p = p.children[curr];
                }
            }
            return ans;
        }
    }

    /**
     * 找到数组中的最大异或值
     */
    public int findMaximumXOR(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Trie root = new Trie();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            root.insert(num);
            max = Math.max(root.fondMaxOr(num), max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaximumXOR(new int[]{0, 7}));
    }

}
