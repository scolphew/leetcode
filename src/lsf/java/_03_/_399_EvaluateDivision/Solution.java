package lsf.java._03_._399_EvaluateDivision;

import base.Print;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    class Pair {
        String string;
        Double value;

        public Pair(String s, Double d) {
            string = s;
            value = d;
        }

        @Override
        public String toString() {
            return String.format("%s->%f", string, value);
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, Set<Pair>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String[] equation = equations[i];
            if (!map.containsKey(equation[0])) {
                map.put(equation[0], new HashSet<>());
            }
            if (!map.containsKey(equation[1])) {
                map.put(equation[1], new HashSet<>());
            }
            map.get(equation[0]).add(new Pair(equation[1], values[i]));
            map.get(equation[1]).add(new Pair(equation[0], 1 / values[i]));
        }

        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] tmp = queries[i];
            ans[i] = dfs(tmp[0], tmp[1], map, new HashSet<>(), 1);

        }
        return ans;
    }

    private double dfs(String start, String end, Map<String, Set<Pair>> map, Set<String> set, double value) {
        if (set.contains(start)) return -1.0;
        if (!map.containsKey(start)) return -1.0;
        if (start.equals(end)) return value;
        set.add(start);

        Set<Pair> pairs = map.get(start);
        double tmp = 0.0;
        for (Pair p : pairs) {
            tmp = dfs(p.string, end, map, set, value * p.value);
            if (tmp != -1.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }

    public static void main(String[] args) {
        double[] doubles = new Solution().calcEquation(new String[][]{
                        {"a", "b"},
                        {"b", "c"}},
                new double[]{2, 3},
                new String[][]{
                        {"a", "c"},
                        {"b", "a"},
                        {"a", "e"},
                        {"a", "a"},
                        {"x", "x"},
                });
        Print.print(doubles);
    }
}
