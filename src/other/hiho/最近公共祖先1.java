package other.hiho;

import java.util.*;

public class 最近公共祖先1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = in.next();
            String b = in.next();
            map.put(b, a);
        }
        int m = in.nextInt();
        a:
        for (int i = 0; i < m; i++) {
            String a = in.next();
            String b = in.next();
            Set<String> s = new HashSet<>();
            while (a != null) {
                s.add(a);
                a = map.get(a);
            }
            while (b != null) {
                if (s.contains(b)) {
                    System.out.println(b);
                    continue a;
                }
                b = map.get(b);
            }
            System.out.println(-1);
        }
    }

}
