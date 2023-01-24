// prob: https://school.programmers.co.kr/learn/courses/30/lessons/67259

package programmers.경주로_건설;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int solution(int[][] board) {
        return getMinSize(board, board.length - 1, board[0].length - 1) * 100;
    }

    private int getMinSize(int[][] board, int dstY, int dstX) {
        boolean[][][] visited = new boolean[4][board.length][board[0].length];
        int[][][] minCosts = new int[4][board.length][board[0].length];
        for (int[][] arrays : minCosts) {
            for (int[] array : arrays) {
                Arrays.fill(array, Integer.MAX_VALUE);
            }
        }
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.cost));
        queue.add(new Node(0, 0, 0, DIRECTION.R));
        queue.add(new Node(0, 0, 0, DIRECTION.D));
        for (boolean[][] subVisited : visited) {
            subVisited[0][0] = true;
        }
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (now.y == dstY && now.x == dstX) {
                return now.cost;
            }
            for (Node nextNode : createNextNodes(now, board, visited, minCosts)) {
                queue.add(nextNode);
                minCosts[now.direction.ordinal()][nextNode.y][nextNode.x] = nextNode.cost;
                visited[now.direction.ordinal()][nextNode.y][nextNode.x] = true;
            }
        }
        throw new IllegalStateException();
    }

    private List<Node> createNextNodes(
        Node now, int[][] board, boolean[][][] visited, int[][][] minCosts
    ) {
        List<Node> nextNodes = new LinkedList<>();
        List<DIRECTION> nextDirections = DIRECTION.createCurveDirections(now.direction);
        nextDirections.add(now.direction);
        for (DIRECTION direction : nextDirections) {
            int nextY = direction.y + now.y;
            int nextX = direction.x + now.x;
            if (nextY < 0 || nextY >= board.length ||
                nextX < 0 || nextX >= board[nextY].length
                || board[nextY][nextX] == 1) {
                continue;
            }
            int cost = now.cost + 1;
            if (direction != now.direction) {
                cost += 5;
            }
            if (visited[now.direction.ordinal()][nextY][nextX]
                && minCosts[now.direction.ordinal()][nextY][nextX] < cost) {
                continue;
            }
            nextNodes.add(new Node(nextY, nextX, cost, direction));
        }
        return nextNodes;
    }

    private enum DIRECTION {
        L(0, -1),
        U(-1, 0),
        R(0, 1),
        D(1, 0),
        ;
        private final int y;
        private final int x;

        DIRECTION(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public static List<DIRECTION> createCurveDirections(DIRECTION direction) {
            List<DIRECTION> curveDirections = new LinkedList<>();
            int nowId = direction.ordinal();
            for (DIRECTION nextDirection : DIRECTION.values()) {
                int nextId = nextDirection.ordinal();
                if (nextId == nowId || Math.abs(nextId - nowId) == 2) {
                    continue;
                }
                curveDirections.add(nextDirection);
            }
            return curveDirections;
        }
    }

    private static class Node {

        private final int y;
        private final int x;
        private final int cost;
        private final DIRECTION direction;

        public Node(int y, int x, int cost, DIRECTION direction) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.direction = direction;
        }
    }
}
