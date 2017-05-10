package lsf._299_BullsandCows;

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int a = secret.charAt(i) - '0';
            int b = guess.charAt(i) - '0';
            if (a == b) {
                bulls++;
            } else {
                if (nums[a] < 0) cows++;
                if (nums[b] > 0) cows++;
                nums[a]++;
                nums[b]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1122", "0001"));
        System.out.println(new Solution().getHint("1807", "7810"));
    }
}
