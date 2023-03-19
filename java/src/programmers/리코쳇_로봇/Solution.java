// prob: https://school.programmers.co.kr/learn/courses/30/lessons/169199

package programmers.리코쳇_로봇;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final static int[][] DIRECTIONS = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    private static Integer findMinDistance(char[][] map, int[][] minDistances, Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        minDistances[start.y][start.x] = 0;
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (map[now.y][now.x] == 'G') {
                return minDistances[now.y][now.x];
            }
            for (int[] direction : DIRECTIONS) {
                Node next = createNextNode(map, now, direction);
                if (minDistances[now.y][now.x] + 1 >= minDistances[next.y][next.x]) {
                    continue;
                }
                minDistances[next.y][next.x] = minDistances[now.y][now.x] + 1;
                queue.add(next);
            }
        }
        return null;
    }

    private static Node createNextNode(char[][] map, Node now, int[] direction) {
        int nextY = now.y;
        int nextX = now.x;
        while (!(nextY < 0 || nextY >= map.length || nextX < 0
            || nextX >= map[nextY].length) &&
            map[nextY][nextX] != 'D') {
            nextY += direction[0];
            nextX += direction[1];
        }
        nextY -= direction[0];
        nextX -= direction[1];
        return Node.create(nextY, nextX);
    }

    public int solution(String[] board) {
        char[][] map = new char[board.length][];
        int[][] minDistances = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
            minDistances[i] = new int[map[i].length];
            Arrays.fill(minDistances[i], Integer.MAX_VALUE);
        }
        char symbol = 'R';
        Node start = findPointAboutSymbol(map, symbol);
        Integer minDistance = findMinDistance(map, minDistances, start);
        if (minDistance != null) {
            return minDistance;
        }
        return -1;
    }

    private Node findPointAboutSymbol(char[][] map, char symbol) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == symbol) {
                    return Node.create(y, x);
                }
            }
        }
        throw new IllegalArgumentException("Not Found Symbol" + symbol);
    }

    private static class Node {

        private final int y;
        private final int x;

        private Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public static Node create(int y, int x) {
            return new Node(y, x);
        }
    }
}
