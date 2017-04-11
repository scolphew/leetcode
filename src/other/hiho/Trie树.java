package other.hiho;

import java.util.Scanner;

public class Trie树 {
    static class Trie {
        int val;
        boolean isEvs;
        Trie[] next;

        Trie() {
            val = 0;
            next = new Trie[26];
        }

        void insert(String s) {
            Trie p = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new Trie();
                    p.val++;
                } else {
                    p.val++;
                }
                p = p.next[c - 'a'];
            }
            p.val++;
            p.isEvs = true;
        }

        int search(String s) {
            Trie t = this;
            for (int i = 0; i < s.length(); i++) {
                if (t.next[s.charAt(i) - 'a'] == null) {
                    return 0;
                }
                t = t.next[s.charAt(i) - 'a'];
            }
            return t.val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Trie t = new Trie();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            t.insert(in.next());
        }
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(t.search(in.next()));
        }
    }

}
