package lsf.java._06_._630_CourseScheduleIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    /**
     * 这里有 n 门不同的在线课程，他们按从 1 到 n 编号。
     * 每一门课程有一定的持续上课时间（课程时间）t 以及关闭时间第 d 天。
     * 每门课都可以从第一天开始学习，联系学习t天，必须在d之前结束
     *
     * 给出 n 个在线课程用 (t, d) 对表示。你的任务是找出最多可以修几门课。
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);//上课时间优先队列
        int time = 0;
        for (int[] c : courses) {
            // 增加下课时间
            time += c[0];
            pq.add(c[0]);
            // 如果下课时间超了，放弃课时最多的课。
            if (time > c[1])
                time -= pq.poll();
        }
        return pq.size();
    }

}
