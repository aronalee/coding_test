package programmers.다단계_칫솔_판매;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<String, Integer> employeeToProfit = new HashMap<>();
    Map<String, List<String>> adjMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        initAttributes(enroll, referral);
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int profit = amount[i] * 100;
            dfs(name, profit);
        }
        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = employeeToProfit.get(enroll[i]);
        }
        return answer;
    }

    private void initAttributes(String[] enroll, String[] referral) {
        adjMap.put("-", new ArrayList<>());
        employeeToProfit.put("-", 0);
        for (String employee : enroll) {
            adjMap.put(employee, new ArrayList<>());
            employeeToProfit.put(employee, 0);
        }
        for (int i = 0; i < referral.length; i++) {
            adjMap.get(enroll[i]).add(referral[i]);
        }
    }

    private void dfs(final String employee, final int newProfit) {
        int tax = newProfit / 10;
        int currentProfit = employeeToProfit.get(employee);
        employeeToProfit.put(employee, currentProfit + newProfit - tax);
        if (tax == 0 || adjMap.get(employee).size() != 1) {
            return;
        }
        String parent = adjMap.get(employee).get(0);
        dfs(parent, tax);
    }
}
