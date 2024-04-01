// prob: https://www.acmicpc.net/problem/21278

package backjoon.back21278;

import java.util.List;

public class Back21278 {
    public static final int EMPTY = Integer.MAX_VALUE / 2;
    private final int[][] adjMatrix;
    private List<Integer> chickenIds = List.of();
    private int minDistance = Integer.MAX_VALUE;

    public Back21278(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public void decideChickens() {
        fillInAdiMatrix();
        this.minDistance = Integer.MAX_VALUE;
        for (int id1 = 1; id1 < adjMatrix.length; id1++) {
            for (int id2 = id1 + 1; id2 < adjMatrix.length; id2++) {
                int subMinDistance = computeMinDistance(id1, id2);
                if (this.minDistance <= subMinDistance) {
                    continue;
                }
                this.minDistance = subMinDistance;
                chickenIds = List.of(id1, id2);
            }
        }
    }

    private void fillInAdiMatrix() {
        for (int k = 0; k < adjMatrix.length; k++) {
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 1; j < adjMatrix[i].length; j++) {
                    if (i == 0) {
                        continue;
                    }
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
    }

    private int computeMinDistance(int id1, int id2) {
        int distance = 0;
        for (int i = 1; i < adjMatrix.length; i++) {
            if (i == id1 || i == id2) {
                continue;
            }
            distance += Math.min(adjMatrix[id1][i], adjMatrix[id2][i]);
        }
        return distance;
    }

    public List<Integer> getChickensBuilds() {
        return this.chickenIds;
    }

    public int getMinDistance() {
        return this.minDistance;
    }
}
