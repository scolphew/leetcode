package other.迅雷;

import java.util.*;

public class 区间合并 {
    static class P {
        int x, y;

        public P(String a) {
            String[] s = a.split(",");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<P> list = new ArrayList<>();
        while (in.hasNext()) {
            String s = in.next();
            if (s.equals("1"))
                break;
            P p = new P(s);
            list.add(p);
        }

        Collections.sort(list, (a, b) -> (a.y - b.y));
        Stack<P> s = new Stack<>();
        for (P p : list) {
            if (s.isEmpty()) {
                s.push(p);
            } else {
                while (!s.isEmpty()) {
                    P x = s.peek();
                    if (x.y >= p.x) {
                        s.pop();
                        if (x.x <= p.x) {
                            //交叉
                            x.y = p.y;
                            s.push(x);
                            break;
                        }

                    } else {
                        s.push(p);
                        break;
                    }
                }
            }

        }
        for (P p : s) {
            System.out.print(p);
            System.out.print(" ");
        }


    }
}
