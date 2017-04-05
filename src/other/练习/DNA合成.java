package other.练习;

import java.util.Scanner;

/**
 * @author scolphew
 */
public class DNA合成 {
    /**
     * DNA分子是以4种脱氧核苷酸为单位连接而成的长链，
     * 这4种脱氧核苷酸分别含有A,T,C,G四种碱基。
     * 碱基互补配对原则：A和T是配对的，C和G是配对的。
     * 如果两条碱基链长度是相同的并且每个位置的碱基是配对的，
     * 那么他们就可以配对合成为DNA的双螺旋结构。现在给出两条碱基链，
     * 允许在其中一条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。
     * 问最少需要多少次让两条碱基链配对成功
     *
     * @param args
     */
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
