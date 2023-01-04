// prob: https://school.programmers.co.kr/learn/courses/30/lessons/131703

package programmers._2차원_동전_뒤집기;

public class Solution {

    private int height;
    private int width;
    private boolean[][] map;
    private boolean[][] dstMap;
    private int answer = Integer.MAX_VALUE;

    public int solution(int[][] beginning, int[][] target) {
        initAttributes(beginning, target);
        updateAnswer(0, 0);
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    private void initAttributes(int[][] beginning, int[][] target) {
        height = beginning.length;
        width = beginning[0].length;
        map = new boolean[height][width];
        dstMap = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (beginning[i][j] == 1) {
                    map[i][j] = true;
                }
                if (target[i][j] == 1) {
                    dstMap[i][j] = true;
                }
            }
        }
    }

    private void updateAnswer(final int column, final int count) {
        if (column == height) {
            int countConvertColumn = 0;
            for (int i = 0; i < width; i++) {
                int result = compareColumnByRowNo(i);
                if (result == -1) {
                    return;
                }
                countConvertColumn += result;
            }
            answer = Math.min(answer, count + countConvertColumn);
            return;
        }
        updateAnswer(column + 1, count);
        flipRowByColumnNo(column);
        updateAnswer(column + 1, count + 1);
        flipRowByColumnNo(column);
    }

    private void flipRowByColumnNo(final int column) {
        for (int i = 0; i < width; i++) {
            map[column][i] = !map[column][i];
        }
    }

    private int compareColumnByRowNo(final int row) {
        int count = 0;
        for (int h = 0; h < height; h++) {
            if (map[h][row] == dstMap[h][row]) {
                count++;
            }
        }
        if (count == 0) {
            return 1;
        }
        if (count == height) {
            return 0;
        }
        return -1;
    }
}
