package lsf.java._464_CanIWin;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal)
            return true;
        if (maxChoosableInteger + 1 >= desiredTotal)
            return false;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;

        Map<Integer, Boolean> map = new HashMap<>();

        return canWin((1 << maxChoosableInteger) - 1, desiredTotal, map);
    }

    public boolean canWin(int num, int total, Map<Integer, Boolean> map) {
        if (total <= 0)
            return false;
        if (map.containsKey(num))
            return map.get(num);
        else
            map.put(num, false);
        int i = 1, mask = 1;
        while (mask <= num) {
            if ((num & mask) > 0 && !canWin(num ^ mask, total - i, map)) {
                map.put(num, true);
                break;
            }
            mask <<= 1;
            i++;
        }
        return map.get(num);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(4, 6));
        System.out.println(new Solution().canIWin(10, 54));
    }
}
