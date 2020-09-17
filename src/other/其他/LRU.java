package other.其他;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

    public int[] LRU(int[][] operators, int k) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(13000, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > k;
            }
        };

        int[] ans = new int[operators.length];
        int index = 0;

        for (int[] op : operators) {

            if (op[0] == 1) {
                // 插入
                map.put(op[1], op[2]);

            } else {
                //读取
                ans[index++] = map.getOrDefault(op[1], -1);
            }

        }
        return Arrays.copyOf(ans, index);
    }

    public static void main(String[] args) {
        LRU l = new LRU();
        l.LRU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}}, 3);
    }

}
