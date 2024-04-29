// prob: https://www.acmicpc.net/problem/21923

package backjoon.back21923;

public class Back21923 {
    public int computeMaxScore(int heightTotal, int widthTotal, int[][] map) {
        int[][] bottomTop = createBottomToTop(heightTotal, widthTotal, map);
        int[][] topToDown = createTopToDown(heightTotal, widthTotal, map);
        int scoreMax = bottomTop[0][0] + topToDown[0][0];
        for (int i = 0; i < heightTotal; i++) {
            for (int j = 0; j < widthTotal; j++) {
                scoreMax = Math.max(scoreMax, bottomTop[i][j] + topToDown[i][j]);
            }
        }
        return scoreMax;
    }

    private int[][] createBottomToTop(int heightTotal, int widthTotal, int[][] map) {
        int[][] bottomTop = new int[heightTotal][widthTotal];
        bottomTop[heightTotal - 1][0] = map[heightTotal - 1][0];
        for (int i = bottomTop.length - 1; i >= 0; i--) {
            for (int j = 0; j < bottomTop[i].length; j++) {
                if (i == bottomTop.length - 1 && j == 0) {
                    continue;
                } else if (j - 1 < 0) {
                    bottomTop[i][j] = bottomTop[i + 1][j] + map[i][j];
                    continue;
                } else if (i + 1 >= heightTotal) {
                    bottomTop[i][j] = bottomTop[i][j - 1] + map[i][j];
                    continue;
                }
                bottomTop[i][j] = Math.max(bottomTop[i + 1][j], bottomTop[i][j - 1]) + map[i][j];
            }
        }
        return bottomTop;
    }

    private int[][] createTopToDown(int heightTotal, int widthTotal, int[][] map) {
        int[][] topToDown = new int[heightTotal][widthTotal];
        topToDown[heightTotal - 1][widthTotal - 1] = map[heightTotal - 1][widthTotal - 1];
        for (int i = heightTotal - 1; i >= 0; i--) {
            for (int j = widthTotal - 1; j >= 0; j--) {
                if (i == heightTotal - 1 && j == widthTotal - 1) {
                    continue;
                } else if (j + 1 >= widthTotal) {
                    topToDown[i][j] = topToDown[i + 1][j] + map[i][j];
                    continue;
                } else if (i + 1 >= heightTotal) {
                    topToDown[i][j] = topToDown[i][j + 1] + map[i][j];
                    continue;
                }
                topToDown[i][j] = Math.max(topToDown[i + 1][j], topToDown[i][j + 1]) + map[i][j];
            }
        }
        return topToDown;
    }
}
