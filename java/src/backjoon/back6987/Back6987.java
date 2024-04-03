// prob: https://www.acmicpc.net/problem/6987

package backjoon.back6987;

import java.util.Arrays;

public class Back6987 {
    private static final int[] MATCH_TEAM1 = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    private static final int[] MATCH_TEAM2 = new int[]{1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};

    public boolean isPossible(int[][] gameMatrix) {
        return isPossible(gameMatrix, 0);
    }

    private boolean isPossible(int[][] gameMatrix, int depth) {
        if (depth == 15) {
            return isEmpty(gameMatrix);
        }
        int team1 = MATCH_TEAM1[depth];
        int team2 = MATCH_TEAM2[depth];
        for (int label = 0; label < 3; label++) {
            if (gameMatrix[team1][label] <= 0 || gameMatrix[team2][2 - label] <= 0) {
                continue;
            }
            gameMatrix[team1][label]--;
            gameMatrix[team2][2 - label]--;
            if (isPossible(gameMatrix, depth + 1)) {
                return true;
            }
            gameMatrix[team1][label]++;
            gameMatrix[team2][2 - label]++;
        }
        return false;
    }

    private boolean isEmpty(int[][] gameMatrix) {
        return Arrays.stream(gameMatrix).flatMapToInt(Arrays::stream).allMatch(score -> score == 0);
    }


}
