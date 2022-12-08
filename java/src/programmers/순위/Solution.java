// prob: https://school.programmers.co.kr/learn/courses/30/lessons/49191

package programmers.순위;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int solution(int n, int[][] results) {
        List<List<Integer>> adjList = new ArrayList<>();
        List<List<Integer>> reverseAdjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            reverseAdjList.add(new ArrayList<>());
        }
        for (final int[] result : results) {
            adjList.get(result[0]).add(result[1]);
            reverseAdjList.get(result[1]).add(result[0]);
        }
        return countCorrectNodes(n, adjList, reverseAdjList);
    }

    private int countCorrectNodes(final int n, final List<List<Integer>> adjList,
        final List<List<Integer>> reverseAdjList) {
        int countCorrectNode = 0;
        for (int i = 1; i <= n; i++) {
            int countWin = countNextNodes(adjList, i, new boolean[n + 1]);
            int countLose = countNextNodes(reverseAdjList, i, new boolean[n + 1]);
            if (countWin + countLose == n - 1) {
                countCorrectNode++;
            }
        }
        return countCorrectNode;
    }

    private int countNextNodes(final List<List<Integer>> adjList, final int start,
        boolean[] visited) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (final Integer next : adjList.get(now)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                count++;
                queue.add(next);
            }
        }
        return count;
    }
}
