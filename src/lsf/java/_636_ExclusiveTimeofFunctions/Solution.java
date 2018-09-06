package lsf.java._636_ExclusiveTimeofFunctions;

import base.Print;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * 给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。
     * 每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。
     * 日志是具有以下格式的字符串：function_id：start_or_end：timestamp。
     * 例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。
     * 函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。
     * 你需要根据函数的 Id 有序地返回每个函数的独占时间。
     * <p>
     * <p>
     * 注意：给出的end是闭区间
     */

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int pre = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : logs) {
            String[] strings = s.split(":");
            int id = Integer.parseInt(strings[0]);
            int time = Integer.parseInt(strings[2]);
            if (strings[1].equals("start")) {
                // 开始新函数
                if (!stack.isEmpty()) {
                    // 如果之前已经有函数了，计算执行时间
                    ans[stack.peek()] += time - pre;
                }
                stack.push(id);
                pre = time;// 记录上一个数据
            } else {
                assert strings[1].equals("end");
                int id2 = stack.pop();
                assert id2 == id;
                // 结束，加上当前函数执行时间。
                // 给出的end是右闭区间，所以都需要+1
                ans[id] += time - pre + 1;
                pre = time + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Print.print(s.exclusiveTime(
                2,
                Arrays.asList(new String[]{"0:start:0", "1:start:2", "1:end:5", "0:end:6"})
        ));
    }

}
