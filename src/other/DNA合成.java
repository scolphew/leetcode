package other;

import java.util.Scanner;

/**
 * @author scolphew
 */
public class DNA合成 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int count = 0;
        int a = 'A' + 'T';
        int b = 'C' + 'G';
        if (s1.length() == s2.length())
            for (int i = 0; i < s1.length(); i++) {
                int x = s1.charAt(i) + s2.charAt(i);
                if (!(x == a || x == b)) {
                    count++;
                }
            }
        System.out.println(count);

    }
}
