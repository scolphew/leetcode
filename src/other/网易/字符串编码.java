package other.网易;

import java.util.Scanner;

public class 字符串编码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char per = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == per) {
                count += 1;
            } else {
                if (per > 0) {
                    System.out.print("" + count + per);
                }
                per = s.charAt(i);
                count = 1;
            }
        }
        System.out.print("" + count + per);
    }
}
