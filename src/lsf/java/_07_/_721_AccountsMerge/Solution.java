package lsf.java._07_._721_AccountsMerge;

import java.util.*;

public class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> eamil2name = new HashMap<>();

        Map<String, String> fathers = new HashMap<>();

        for (List<String> account : accounts) {
            int n = account.size();
            String name = account.get(0);
            String firstEmail = account.get(1);
            eamil2name.putIfAbsent(firstEmail, name);

            String f1 = getFather(fathers, firstEmail);

            for (int i = 2; i < n; i++) {
                String email = account.get(i);
                String f2 = getFather(fathers, email);
                if (!f1.equals(f2)) {
                    fathers.put(f2, f1);
                }
            }
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String email : fathers.keySet()) {
            map.computeIfAbsent(getFather(fathers, email), x -> new ArrayList()).add(email);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
            entry.getValue().add(0, eamil2name.get(entry.getKey()));
        }

        return new ArrayList<>(map.values());
    }

    public String getFather(Map<String, String> map, String email) {
        map.putIfAbsent(email, email);
        while (!map.get(email).equals(email)) {
            email = map.get(email);
        }
        return email;
    }


    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.accountsMerge(
                Arrays.asList(
                        Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                        Arrays.asList("John", "johnnybravo@mail.com"),
                        Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                        Arrays.asList("Mary", "mary@mail.com")
                )
        ));
    }
}
