// prob: https://www.acmicpc.net/problem/7682

package backjoon.back7682;

public class Back7682 {
    public boolean isPossible(char[][] map) {
        int markXCount = countMark(map, 'X');
        int markOCount = countMark(map, 'O');
        int markXEndCount = countEndMark(map, 'X');
        int markOEndCount = countEndMark(map, 'O');
        if (markXCount - markOCount == 1 && markXEndCount == 1 && markOEndCount == 0) {
            return true;
        } else if (markXCount == markOCount && markXEndCount == 0 && markOEndCount == 1) {
            return true;
        } else return markXCount == 5 && markOCount == 4 && (markXEndCount == 2 || markXEndCount == 0) && markOEndCount == 0;
    }

    private int countMark(char[][] map, char mark) {
        int count = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (mark == map[y][x])
                    count++;
            }
        }
        return count;
    }

    private int countEndMark(char[][] map, char mark) {
        int count = 0;
        count += countEndCross(map, mark);
        count += countEndDiagonal(map, mark);
        return count;
    }

    private int countEndCross(char[][] map, char mark) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            int countWidth = 0;
            int countHeight = 0;
            for (int j = 0; j < map[i].length; j++) {
                countWidth += map[i][j] == mark ? 1 : 0;
                countHeight += map[j][i] == mark ? 1 : 0;
            }
            if (countWidth == 3) {
                count++;
            }
            if (countHeight == 3) {
                count++;
            }
        }
        return count;
    }

    private int countEndDiagonal(char[][] map, char mark) {
        int count = 0;
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < map.length; i++) {
            countLeft += map[i][i] == mark ? 1 : 0;
            countRight += map[i][map.length - 1 - i] == mark ? 1 : 0;
        }
        if (countLeft == 3) {
            count++;
        }
        if (countRight == 3) {
            count++;
        }
        return count;
    }

}
