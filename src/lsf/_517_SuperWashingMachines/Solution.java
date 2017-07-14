package lsf._517_SuperWashingMachines;

public class Solution {
    public int findMinMoves(int[] machines) {
        if (machines == null)
            return -1;
        int sum = 0;
        int n = machines.length;
        for (int i : machines)
            sum += i;

        if (sum % n != 0)
            return -1;
        int eachMum = sum / n;
        int min_move = 0, balance = 0;

        for (int i = 0; i < n; i++) {
            balance += machines[i] - eachMum;
            min_move = Math.max(min_move, Math.max(machines[i] - eachMum, Math.abs(balance)));
        }
        return min_move;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMinMoves(new int[]{0, 4, 7, 4, 0}));
    }
}
