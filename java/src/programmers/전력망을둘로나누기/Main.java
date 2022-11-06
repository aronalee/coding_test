// prob: https://school.programmers.co.kr/learn/courses/30/lessons/86971

package programmers.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> adjList = createAdjList(n, wires);
        int diffTower = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            diffTower = Math.min(diffTower, splitWire(adjList, wire));
        }
        return diffTower;
    }

    private int countArea(List<List<Integer>> adjList, int start, int skipNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];
        queue.add(start);
        visited[start] = true;
        int area = 1;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (Integer next : adjList.get(now)) {
                if (visited[next] || next == skipNode) {
                    continue;
                }
                queue.add(next);
                visited[next] = true;
                area++;
            }
        }
        return area;
    }

    private int splitWire(List<List<Integer>> adjList, int[] wire) {
        int area1 = countArea(adjList, wire[0], wire[1]);
        int area2 = countArea(adjList, wire[1], wire[0]);
        return Math.abs(area1 - area2);
    }

    private List<List<Integer>> createAdjList(int n, int[][] wires) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            adjList.get(wire[0]).add(wire[1]);
            adjList.get(wire[1]).add(wire[0]);
        }
        return adjList;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(9, new int[][]{
                {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
        });
        System.out.println(result);
    }
}
