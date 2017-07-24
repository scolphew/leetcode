package other.hiho;

import java.util.HashMap;
import java.util.Scanner;

public class 并查集 {
    static HashMap<String, String> relations = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int flag = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            if (flag == 0) {
                String father1 = find(s1);
                String father2 = find(s2);
                if (!father1.equals(father2)) {
                    relations.put(father2, father1);
                }
            } else {
                String result = getRelation(s1, s2);
                System.out.println(result);
            }
        }
        sc.close();
    }

    private static String find(String s1) {
        String father = s1;
        relations.putIfAbsent(father, father);

        while (!relations.get(father).equals(father)) {
            father = relations.get(father);
        }
        return father;
    }


    private static String getRelation(String s1, String s2) {
        String father1 = find(s1);
        String father2 = find(s2);
        if (father1.equals(father2)) {
            return "yes";
        } else {
            return "no";
        }
    }
}
