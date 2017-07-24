package other.hiho;

import java.util.*;

public class 最近公共祖先2 {
    private static class Pair {

        String x, y;

        public Pair(String x, String y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Map<String, List<String>> map = new HashMap<>(); //需要求的集合{a:needLCAWithA}
    private static Map<String, List<String>> root = new HashMap<>();//树,{a:sonsOfA}
    private static Map<String, String> res = new HashMap<>(); // {a+b|b+a:lca(a,b)}
    private static Map<String, String> unSet = new HashMap<>(); // {}
    private static Set<String> visted = new HashSet<>();

    private static void LCA(String u) {
        List<String> list = root.get(u);
        if (list != null) {
            for (String son : list) {
                LCA(son);
                untion(u, son);
            }
        }

        visted.add(u);
        List<String> list2 = map.get(u);
        if (list2 == null)
            return;
        for (String s : list2) {
            if (visted.contains(s)) {
                String ancestor = find(s);
                res.put(u + s, ancestor);
            }
        }

    }

    private static void untion(String u, String s) {
        String fdu = find(u);
        String fds = find(s);
        unSet.put(fds, fdu);

    }

    private static String find(String s) {
        if (unSet.get(s) == null) {
            unSet.put(s, s);
            return s;
        }
        if (unSet.get(s).equals(s)) return s;
        String str = find(unSet.get(s));
        unSet.put(s, str);
        return str;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Pair> list = new ArrayList<>();

        String fatherOfAll = null;

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String a = in.next();
            String b = in.next();
            if (fatherOfAll == null)
                fatherOfAll = a;

            root.computeIfAbsent(a, k -> new ArrayList<>()).add(b);

            //if (root.get(a) == null) {
            //    root.put(a, new ArrayList<String>());
            //}
            //root.get(a).add(b);
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            String a = in.next();
            String b = in.next();
            list.add(new Pair(a, b));
        }


        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            map.computeIfAbsent(p.x, k -> new ArrayList<>()).add(p.y);
            map.computeIfAbsent(p.y, k -> new ArrayList<>()).add(p.x);
            //if (map.get(p.x) == null) {
            //    map.put(p.x, new ArrayList<String>());
            //}
            //map.get(p.x).add(p.y);
            //
            //if (map.get(p.y) == null) {
            //        map.put(p.y, new ArrayList<String>());
            //    }
            //    map.get(p.y).add(p.x);

        }

        LCA(fatherOfAll);
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            String s1 = p.x + p.y;
            String s2 = p.y + p.x;
            String str = res.get(s1) == null ? res.get(s2) : res.get(s1);
            System.out.println(str);
        }

    }

}
