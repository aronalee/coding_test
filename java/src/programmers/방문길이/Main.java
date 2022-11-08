// prob: https://school.programmers.co.kr/learn/courses/30/lessons/49994

package programmers.방문길이;

enum DIRECTION {
    LEFT(0, -1),
    RIGHT(0, 1),
    UP(1, 0),
    DOWN(-1, 0),
    NONE(0, 0),
    ;

    private final int y;
    private final int x;

    DIRECTION(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int y() {
        return y;
    }

    public int x() {
        return x;
    }
}

class Solution {

    public int solution(String dirs) {
        int answer = 0;
        int[] point = new int[]{5, 5};
        boolean[][][] visitedEdge = new boolean[11][11][4];
        for (String dir : dirs.split("")) {
            DIRECTION direction = switch (dir) {
                case "L" -> DIRECTION.LEFT;
                case "U" -> DIRECTION.UP;
                case "R" -> DIRECTION.RIGHT;
                case "D" -> DIRECTION.DOWN;
                default -> DIRECTION.NONE;
            };
            int nextY = point[0] + direction.y();
            int nextX = point[1] + direction.x();
            if (nextY < 0 || nextY > 10 || nextX < 0 || nextX > 10) {
                continue;
            }
            int dirIdx = switch (dir) {
                case "L" -> 0;
                case "U" -> 1;
                case "R" -> 2;
                case "D" -> 3;
                default -> 4;
            };
            if (!visitedEdge[nextY][nextX][dirIdx]) {
                answer++;
            }
            visitedEdge[nextY][nextX][dirIdx] = true;
            visitedEdge[point[0]][point[1]][(dirIdx + 2) % 4] = true;
            point[0] = nextY;
            point[1] = nextX;
        }
        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("ULURRDLLU"));
//        System.out.println(s.solution("LULLLLLLU"));
    }
}
