// prob: https://www.acmicpc.net/problem/1240

package backjoon.back1240;

import java.util.Arrays;

public class Back1240 {


    private int[][] minDistances;

    /**
     * 플로이드 위셜 알고리즘으로 모든 정점에서 모든 정점으로의 최단 경로를 구한다.
     *
     * @param adjArray 인접 행렬
     */
    public void initFloyidWarshall(int[][] adjArray, int n) {
        if (this.minDistances != null) {
            return;
        }
        this.minDistances = new int[n + 1][];
        for (int i = 0; i < adjArray.length; i++) {
            this.minDistances[i] = Arrays.copyOf(adjArray[i], adjArray.length);
        }
        for (int y = 0; y < this.minDistances.length; y++) {
            for (int x = 0; x < this.minDistances[y].length; x++) {
                if (this.minDistances[y][x] != 0 || y == x) {
                    continue;
                }
                this.minDistances[y][x] = Integer.MAX_VALUE;
            }
        }
        for (int k = 1; k < this.minDistances.length; k++) {
            for (int y = 1; y < this.minDistances.length; y++) {
                for (int x = 1; x < this.minDistances[y].length; x++) {
                    if (this.minDistances[y][k] == Integer.MAX_VALUE
                        || this.minDistances[k][x] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int distance = this.minDistances[y][k] + this.minDistances[k][x];
                    if (this.minDistances[y][x] > distance) {
                        this.minDistances[y][x] = distance;
                    }
                }
            }
        }
    }

    /**
     * 플로위드 위셜로 초기화한 minDistances에 저장된 최단거리를 빼서 반환한다.
     *
     * @param srcNode 출발 노드
     * @param dstNode 도착 노드
     * @return 최단 거리
     */
    public int getMinDistance(int srcNode, int dstNode) {
        if (this.minDistances == null) {
            throw new IllegalAccessError("최소 거리 초기화 필요");
        }
        return minDistances[srcNode][dstNode];
    }
}
