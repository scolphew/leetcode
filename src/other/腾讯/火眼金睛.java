package other.腾讯;

import java.util.*;

public class 火眼金睛 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set1 = new TreeSet<>();//作弊的人
        Map<Integer, Set<Integer>> map = new TreeMap();//回答问题对
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int ask = in.nextInt();
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int ans = in.nextInt();
                if (map.containsKey(ans)) {
                    map.get(ans).add(ask);
                } else {
                    Set<Integer> tmp = new HashSet<>();
                    tmp.add(ask);
                    map.put(ans, tmp);
                }
            }
        }
        for (int i : map.keySet()) {
            for (int j : map.get(i)) {
                if (i != j && map.containsKey(j) && map.get(j).contains(i)) {
                    set1.add(i);
                    set1.add(j);
                }
            }
        }
        Set<Integer> set = new TreeSet<>();
        for (int i : set1) {
            if (map.containsKey(i)) {
                for (int j : set1) {
                    if (j <= i)
                        continue;
                    if (map.containsKey(j)) {
                        for (int x : map.get(i))
                            for (int y : map.get(j))
                                if (x == y)
                                    set.add(x);
                    }
                }
            }
        }
        for (int i : set)
            set1.add(i);

        System.out.println(set1.size());

        if (!set1.isEmpty()) {
            Iterator<Integer> iter = set1.iterator();
            System.out.print(iter.next());
            while (iter.hasNext()) {
                System.out.print(" " + iter.next());
            }
        }
    }
}
