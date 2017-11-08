package lsf.java._526_BeautifulArrangement;

public class Solution {
    public int countArrangement(int N) {
        int[] nums = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        int ans = 0;
        int i = 1, j = 1;
        while (i > 0) {
            while (j <= N) {
                if (!visited[j] && (i % j == 0 || j % i == 0)) {  //如果给位置可以放
                    nums[i] = j;
                    visited[j] = true;
                    j = 1;
                    break;
                } else {
                    ++j;
                }
            }

            if (nums[i] == 0) { //如果没找到能放的数字
                if (i == 1) {
                    break;
                } else {
                    --i;
                    j = nums[i] + 1;
                    visited[nums[i]] = false;
                    nums[i] = 0;
                    continue;
                }
            }

            if (i == N) {
                ans += 1;
                j = nums[i] + 1;
                visited[nums[i]] = false;
                nums[i] = 0;
                continue;
            }
            ++i;
        }
        return ans;
    }

    public String string(int[] a) {
        String s = "";
        for (int i : a)
            s += i + "  ";
        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countArrangement(15));
    }

}
