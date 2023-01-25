// prob: https://www.acmicpc.net/problem/1652

package backjoon.back1652;

public class Back1652 {

    public int[] getAnswer(final boolean[][] map) {
        int n = map.length;
        int[] countPositions = new int[2];
        for (int i = 0; i < n; i++) {
            int positionSizeWidth = 0;
            int positionSizeHeight = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    if (positionSizeWidth > 1) {
                        countPositions[0]++;
                    }
                    positionSizeWidth = -1;
                }
                if (map[j][i]) {
                    if (positionSizeHeight > 1) {
                        countPositions[1]++;
                    }
                    positionSizeHeight = -1;
                }
                positionSizeWidth++;
                positionSizeHeight++;
            }
            if (positionSizeWidth > 1) {
                countPositions[0]++;
            }
            if (positionSizeHeight > 1) {
                countPositions[1]++;
            }
        }
        return countPositions;
    }
}
