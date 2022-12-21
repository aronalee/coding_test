// prob: https://school.programmers.co.kr/learn/courses/30/lessons/132266

package programmers.부대복귀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (final int[] road : roads) {
            int p1 = road[0];
            int p2 = road[1];
            adjList.get(p1).add(p2);
            adjList.get(p2).add(p1);
        }
        int[] minDistances = bfs(destination, adjList, n);
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            answer[i] = minDistances[source];
        }
        return answer;
    }

    private int[] bfs(final int src, final List<List<Integer>> adjList,
        final int n) {
        boolean[] visited = new boolean[n + 1];
        int[] minDistances = new int[n + 1];
        Arrays.fill(minDistances, -1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, 0));
        visited[src] = true;
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            minDistances[now.id] = now.weight;
            for (final Integer nextId : adjList.get(now.id)) {
                if (visited[nextId]) {
                    continue;
                }
                visited[nextId] = true;
                queue.add(new Node(nextId, now.weight + 1));
            }
        }
        return minDistances;
    }

    private static class Node {

        private final int id;
        private final int weight;

        public Node(final int id, final int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

}
