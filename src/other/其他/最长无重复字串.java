package other.其他;

import java.util.HashMap;
import java.util.Map;

public class 最长无重复字串 {

    public int maxLength(int[] arr) {
        int ans = 0;
        int start = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            if (map.containsKey(tmp)) {
                start = Math.max(map.get(tmp), start);
            }
            map.put(tmp, i);
            ans = Math.max(ans, i - start);

        }
        return ans;
    }

    public static void main(String[] args) {
        最长无重复字串 s = new 最长无重复字串();
        System.out.println(s.maxLength(new int[]{1, 2, 3, 2, 4, 5, 2, 3}));
    }

}
