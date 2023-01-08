// prob: https://school.programmers.co.kr/learn/courses/30/lessons/60063

package programmers.블록_이동하기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final int[][] DIRECTIONS = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private final int[][] ACROSS_DIRECTIONS = new int[][]{
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    private int[][] board;
    private boolean[][][] visited;

    public int solution(int[][] board) {
        int n = board.length;
        this.board = board;
        this.visited = new boolean[2][n][n];
        return bfs(new int[][]{{0, 0}, {0, 1}}, board.length);
    }

    private int bfs(final int[][] start, final int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        checkingVisited(start);
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            for (int[] point : now.points) {
                if (point[0] == n - 1 && point[1] == n - 1) {
                    return now.time;
                }
            }
            addDirections(n, queue, now);
            addRotations(n, queue, now);
        }
        throw new IllegalArgumentException();
    }

    private void addDirections(int n, Queue<Node> queue, Node now) {
        for (int[] direction : DIRECTIONS) {
            int[][] nextPoints = createDirectionPoint(now, direction);
            if (isNotRangeInBoard(n, nextPoints)
                || isBlocked(nextPoints)
                || isVisited(nextPoints)) {
                continue;
            }
            checkingVisited(nextPoints);
            queue.add(new Node(nextPoints, now.time + 1));
        }
    }

    private int[][] createDirectionPoint(Node now, int[] direction) {
        int[][] nextPoints = new int[2][2];
        for (int i = 0; i < nextPoints.length; i++) {
            nextPoints[i] = Arrays.copyOf(now.points[i], now.points[i].length);
            nextPoints[i][0] += direction[0];
            nextPoints[i][1] += direction[1];
        }
        return nextPoints;
    }

    private void addRotations(int n, Queue<Node> queue, Node now) {
        for (int[] rotation : ACROSS_DIRECTIONS) {
            for (int id = 0; id < 2; id++) {
                int[][] nextPoints = createRotatedPoint(now, rotation, id);
                if (isNotRangeInBoard(n, nextPoints)
                    || isBlocked(nextPoints)
                    || isVisited(nextPoints)
                    || isNotRotated(now.points, nextPoints, id)) {
                    continue;
                }
                checkingVisited(nextPoints);
                queue.add(new Node(nextPoints, now.time + 1));
            }
        }
    }

    private int[][] createRotatedPoint(Node now, int[] direction, int fixedPointId) {
        int[][] nextPoints = new int[2][2];
        for (int i = 0; i < nextPoints.length; i++) {
            nextPoints[i] = Arrays.copyOf(now.points[i], now.points[i].length);
            if (i == fixedPointId) {
                continue;
            }
            nextPoints[i][0] += direction[0];
            nextPoints[i][1] += direction[1];
        }
        return nextPoints;
    }

    private boolean isNotRotated(int[][] currentPoint, int[][] nextPoints, int fixedPointId) {
        int diffPoint = Math.abs(nextPoints[0][0] - nextPoints[1][0])
            + Math.abs(nextPoints[0][1] - nextPoints[1][1]);
        if (diffPoint != 1) {
            return true;
        }
        int[] fixedPoint = currentPoint[fixedPointId];
        int[] beforePoint = currentPoint[(fixedPointId + 1) % 2];
        int[] afterPoint = nextPoints[(fixedPointId + 1) % 2];
        int[] acrossPoint = Arrays.copyOf(currentPoint[fixedPointId],
            currentPoint[fixedPointId].length);
        for (int i = 0; i < 2; i++) {
            if (fixedPoint[i] != beforePoint[i]) {
                acrossPoint[i] = beforePoint[i];
            }
            if (fixedPoint[i] != afterPoint[i]) {
                acrossPoint[i] = afterPoint[i];
            }
        }
        return board[acrossPoint[0]][acrossPoint[1]] == 1;
    }

    private void checkingVisited(int[][] point) {
        boolean[][] selectedVisited = selectVisited(point);
        selectedVisited[point[0][0]][point[0][1]] = true;
        selectedVisited[point[1][0]][point[1][1]] = true;
    }

    private boolean isNotRangeInBoard(int n, int[][] nextPoints) {
        for (int[] nextPoint : nextPoints) {
            if (nextPoint[0] < 0 || nextPoint[0] >= n
                || nextPoint[1] < 0 || nextPoint[1] >= n) {
                return true;
            }
        }
        return false;
    }

    private boolean isBlocked(int[][] nextPoints) {
        for (int[] nextPoint : nextPoints) {
            int y = nextPoint[0];
            int x = nextPoint[1];
            if (board[y][x] == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean isVisited(int[][] nextPoints) {
        int countVisited = 0;
        for (int[] nextPoint : nextPoints) {
            int y = nextPoint[0];
            int x = nextPoint[1];
            if (selectVisited(nextPoints)[y][x]) {
                countVisited++;
            }
        }
        return countVisited == 2;
    }

    private boolean[][] selectVisited(final int[][] point) {
        if (point[0][0] - point[1][0] == 0) {
            return visited[0];
        }
        return visited[1];
    }

    private static class Node {

        private final int[][] points;
        private final int time;

        public Node(int[][] points, int time) {
            this.points = points;
            this.time = time;
        }
    }
}
