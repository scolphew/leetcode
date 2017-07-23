package other.hiho;

import java.util.*;

public class 数组重排3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            System.out.println(foo(s));
        }

    }

    public static int foo(String x) {
        int length = x.length();

        if (length == 1)
            return 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(i + 1);
        }
        String res = sb.toString();
        if (x.equals(res)) {
            return 0;
        }
        if (length == 2)
            return -1;

        Set<String> set = new HashSet<>();
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2;
        q1.offer(x);
        set.add(x);
        int index = 1;

        while (!q1.isEmpty()) {
            q2 = new LinkedList<>();
            while (!q1.isEmpty()) {
                String tmp = q1.poll();
                for (int i = 1; i < length; i++) {
                    sb = new StringBuilder();
                    String cur1 = "" + tmp.charAt(i - 1) + tmp.charAt(i);//当前移动的两个字符
                    String cur2;//剩下的两个字符
                    for (int j = 0; j < length; j++) {
                        if (j != i && j != i - 1)
                            sb.append(tmp.charAt(j));
                    }
                    cur2 = sb.toString();

                    for (int j = 0; j <= cur2.length(); j++) {
                        String newString = cur2.substring(0, j) + cur1 + cur2.substring(j);
                        if (newString.equals(res))
                            return index;
                        if (!set.contains(newString)) {
                            set.add(newString);
                            q2.offer(newString);
                        }
                    }
                }
            }
            index++;
            q1 = q2;
        }

        return -1;
    }

}
