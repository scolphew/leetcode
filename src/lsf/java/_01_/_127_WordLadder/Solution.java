package lsf.java._01_._127_WordLadder;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(s.ladderLength("hit", "cog", list));
    }

    /**
     * 求beginWord经过多少次变换能够达到endWord。要求，每次只能变换一个字母，切必须在wordList中出现
     * 从begin开始广度遍历wordList中的单词，知道找到目标，返回层数
     * 否则返回0
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        words.remove(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord)) return level;
                for (String neighbor : neighbors(str, words)) {
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;

    }

    public List<String> neighbors(String s, Set<String> woedList) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char c = 'a'; c < 'z'; c++) {
                chars[i] = c;
                String word = new String(chars);
                if (woedList.contains(word)) {
                    res.add(word);
                    woedList.remove(word);
                }
            }
        }
        return res;
    }
}
