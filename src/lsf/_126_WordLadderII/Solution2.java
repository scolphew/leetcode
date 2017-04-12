package lsf._126_WordLadderII;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(s.findLadders("hit", "cog", list));


        list = new ArrayList<>();
        for (String sss : new String[]{"miss", "dusk", "kiss", "musk", "tusk", "diss", "disk", "sang", "ties", "muss"}) {
            list.add(sss);
        }
        System.out.println(s.findLadders("kiss", "tusk", list));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> results = new ArrayList<>();
        dict.add(endWord);

        Deque<List<String>> paths = new LinkedList<>();
        List<String> path0 = new LinkedList<>();
        path0.add(beginWord);
        paths.add(path0);
        int level = 1, lastLevel = Integer.MAX_VALUE;
        Set<String> wordsPerLevel = new HashSet<>();
        while (!paths.isEmpty()) {
            List<String> path = paths.poll();
            if (path.size() > level) {
                dict.removeAll(wordsPerLevel);
                wordsPerLevel.clear();
                level = path.size();
                if (level > lastLevel)
                    break;
            }
            String last = path.get(level - 1);
            char[] chars = last.toCharArray();
            for (int index = 0; index < last.length(); index++) {
                char original = chars[index];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[index] = c;
                    String next = new String(chars);
                    if (dict.contains(next)) {
                        wordsPerLevel.add(next);
                        List<String> nextPath = new LinkedList<>(path);
                        nextPath.add(next);
                        if (next.equals(endWord)) {
                            results.add(nextPath);
                            lastLevel = level;
                        } else
                            paths.addLast(nextPath);
                    }
                }
                chars[index] = original;
            }
        }
        return results;
    }
}
