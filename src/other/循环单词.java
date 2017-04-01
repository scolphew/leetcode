package other;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author scolphew
 */
public class 循环单词 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String string = in.next();
            boolean flag = false;
            for (String s : set) {
                if (s.length() == string.length() * 2 && s.indexOf(string) >= 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
                set.add(string + string);
            }
        }
        System.out.println(count);
    }
}
