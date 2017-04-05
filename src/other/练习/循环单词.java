package other.练习;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author scolphew
 */
public class 循环单词 {
    /**
     * 如果一个单词通过循环右移获得的单词，
     * 我们称这些单词都为一种循环单词。
     * 例如：picture 和 turepic 就是属于同一种循环单词。
     * 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
     * @param args
     */
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
