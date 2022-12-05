// prob: https://school.programmers.co.kr/learn/courses/30/lessons/49189

package programmers.가장먼노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int solution(int n, int[][] edges) {
        int answer = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (final int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] distances = bfs(adjList);
        int maxDistance = getMaxDistance(distances);
        for (final int distance : distances) {
            if (distance == maxDistance) {
                answer++;
            }
        }
        return answer;
    }

    private int[] bfs(final List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] routes = new int[adjList.size()];
        boolean[] visited = new boolean[adjList.size()];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (final Integer next : adjList.get(now)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                routes[next] = routes[now] + 1;
                queue.add(next);
            }
        }
        return routes;
    }

    private int getMaxDistance(final int[] routes) {
        int maxValue = 0;
        for (final int route : routes) {
            maxValue = Math.max(maxValue, route);
        }
        return maxValue;
    }
}
