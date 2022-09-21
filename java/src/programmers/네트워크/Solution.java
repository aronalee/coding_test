// prob: https://school.programmers.co.kr/learn/courses/30/lessons/43162

package programmers.네트워크;

import java.util.LinkedList;
import java.util.Queue;


class Solution {
    boolean[] visited;
    int[][] computers;

    public int solution(int n, int[][] computers) {
        this.visited = new boolean[n];
        this.computers = computers;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            answer++;
            this.exploreNetwork(i);
        }
        return answer;
    }

    public void exploreNetwork(int startLocalhost) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startLocalhost);
        while (queue.size() > 0) {
            int localhost = queue.remove();
            if (visited[localhost]) {
                continue;
            }
            visited[localhost] = true;
            for (int nextLocalhost = 0; nextLocalhost < computers[localhost].length; nextLocalhost++) {
                if (!visited[nextLocalhost] && computers[localhost][nextLocalhost] == 1) {
                    queue.add(nextLocalhost);
                }
            }
        }
    }
}