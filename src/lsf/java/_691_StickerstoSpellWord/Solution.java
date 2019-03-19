package lsf.java._691_StickerstoSpellWord;

class Solution {
    /**
     * 我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
     * 你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 target。
     * 如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。
     * 拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回 -1。
     */
    public int minStickers(String[] stickers, String target) {
        int N = target.length();
        int l = 1 << N;
        // dp[i] 表示把i转换为二进制之后，只用对应为组成单词的答案
        // 如 target=abcd  i=10=1010   表示 构成bd需要至少几个单词
        int[] dp = new int[l];
        // -1 表示未进行
        for (int i = 1; i < l; i++) dp[i] = -1;

        for (int state = 0; state < l; state++) {
            if (dp[state] == -1) continue; // 表示该状态不可达

            for (String sticker : stickers) {
                int now = state;

                // 下面双层遍历表示让sticker中每一个字母对应target中每一个字母
                for (char letter : sticker.toCharArray()) {
                    for (int i = 0; i < N; i++) {
                        // 表示target中这个字母已经被填充了
                        if (((now >> i) & 1) == 1) continue;

                        // 如果相等，表示可以填充
                        if (target.charAt(i) == letter) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1;
                }
            }
        }
        return dp[l - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minStickers(new String[]{"aa"}, "aaa"));
    }
}

