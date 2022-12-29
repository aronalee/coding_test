// prob: https://school.programmers.co.kr/learn/courses/30/lessons/133500

package programmers.등대;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<List<Integer>> adjList;

    public int solution(int n, int[][] lighthouse) {
        init(n, lighthouse);
        boolean[] isTurnOns = new boolean[n + 1];
        gotoAllRoutes(isTurnOns);
        int count = 0;
        for (final boolean isTurnOn : isTurnOns) {
            if (isTurnOn) {
                count++;
            }
        }
        return count;
    }

    private void gotoAllRoutes(final boolean[] isTurnOns) {
        while (!isGotoAllRoutes()) {
            for (int house = 0; house < adjList.size(); house++) {
                List<Integer> nextHouses = adjList.get(house);
                if (nextHouses.size() != 1) {
                    continue;
                }
                turnOnHouse(house, isTurnOns);
            }
        }
    }

    private void init(final int n, final int[][] lighthouse) {
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new LinkedList<>());
        }
        for (final int[] houses : lighthouse) {
            int house1 = houses[0];
            int house2 = houses[1];
            adjList.get(house1).add(house2);
            adjList.get(house2).add(house1);
        }
    }

    private boolean isGotoAllRoutes() {
        for (final List<Integer> list : adjList) {
            if (list.size() > 0) {
                return false;
            }
        }
        return true;
    }

    private void turnOnHouse(final int house, final boolean[] isTurnOn) {
        Integer onHouse = adjList.get(house).get(0);
        isTurnOn[onHouse] = true;
        adjList.get(house).clear();
        List<Integer> connectedOnHouse = adjList.get(onHouse);
        while (!connectedOnHouse.isEmpty()) {
            Integer nextHouse = connectedOnHouse.remove(0);
            adjList.get(nextHouse).remove(onHouse);
        }
    }
}
