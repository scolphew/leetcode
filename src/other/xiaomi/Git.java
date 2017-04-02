package other.xiaomi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author scolphew
 */
public class Git {
    /**
     * 临界矩阵表示树，0为根，求两点的最近公共祖先节点
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public int getSplitNode(String[] matrix, int indexA, int indexB) {
        int V = matrix.length; //顶点个数
        int[] father = new int[V];
        father[0] = -1;
        for (int i = 1; i < V; i++) {
            father[i] = -2;
        }
        int level[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int cur_level = 0;
        while (!q.isEmpty()) {
            cur_level += 1;
            Queue<Integer> new_q = new LinkedList<>();
            for (int i : q) {
                foo(matrix, father, i, new_q, level, cur_level);
            }
            q = new_q;
        }

        int level_a = level[indexA];
        int level_b = level[indexB];
        while (indexA != indexB) {
            if (level_a == level_b) {
                indexA = father[indexA];
                indexB = father[indexB];
                level_a -= 1;
                level_b -= 1;
            } else if (level_a > level_b) {
                indexA = father[indexA];
                level_a -= 1;
            } else {
                indexB = father[indexB];
                level_b -= 1;
            }
        }

        return indexA;
    }

    public void foo(String[] matrix, int[] father, int n, Queue q, int[] level, int cur_level) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[n].charAt(i) == '1') {
                if (father[i] == -2) {
                    father[i] = n;
                    level[i] = cur_level;
                    q.offer(i);
                }
            }
        }
    }


    public static void main(String[] args) {
        Git git = new Git();
        String[] strings = {"01011", "10100", "01000", "10000", "10000"};
        System.out.println(git.getSplitNode(strings, 3, 2));
    }

}
