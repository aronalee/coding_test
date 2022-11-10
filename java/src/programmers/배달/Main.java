// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12978

package programmers.배달;

import java.util.Arrays;

class Solution {

    private static final int INF = 500_001;

    private void setMinDistanceByAdjMatrix(int[][] adjMatrix, int totalNode) {
        for (int k = 1; k < totalNode; k++) {
            for (int i = 1; i < totalNode; i++) {
                for (int j = 1; j < totalNode; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] adjMatrix = new int[N + 1][N + 1];
        for (final int[] matrix : adjMatrix) {
            Arrays.fill(matrix, INF);
        }
        for (int i = 0; i < N; i++) {
            adjMatrix[i][i] = 0;
        }
        for (final int[] edge : road) {
            int node1 = edge[0];
            int node2 = edge[1];
            int distance = edge[2];
            adjMatrix[node1][node2] = Math.min(adjMatrix[node1][node2], distance);
            adjMatrix[node2][node1] = Math.min(adjMatrix[node2][node1], distance);
        }
        setMinDistanceByAdjMatrix(adjMatrix, N + 1);
        for (final int distance : adjMatrix[1]) {
            if (distance > K) {
                continue;
            }
            answer++;
        }
        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5,
            new int[][]{
                {1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}
            }, 3));
        System.out.println(s.solution(6,
            new int[][]{
                {1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}
            }, 4));
    }

}
