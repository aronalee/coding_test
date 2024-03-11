// prob: https://www.acmicpc.net/problem/22944

package backjoon.back22944;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Back22944 {
    private final int hp;
    private final int umbrella;
    private final int[][] map;

    private final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public Back22944(int hp, int umbrella, int[][] map) {
        this.hp = hp;
        this.umbrella = umbrella;
        this.map = map;
    }

    public int findCountOfMinMoving(Point startPoint) {
        int[][] maxOfSumHpAndUmbrellas = new int[map.length][map[0].length];
        for (int[] maxOfSumHpAndUmbrella : maxOfSumHpAndUmbrellas) {
            Arrays.fill(maxOfSumHpAndUmbrella, Integer.MIN_VALUE);
        }
        startPoint.fillValue(maxOfSumHpAndUmbrellas, hp);
        int minCount = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(hp, 0, startPoint, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.point.isSafe(map)) {
                minCount = Math.min(minCount, current.count);
            }
            for (int[] direction : DIRECTIONS) {
                Point nextPoint = current.point.move(direction);
                if (nextPoint.isOverMap(map)) {
                    continue;
                }
                Node nextNode = current.moveOnce(map, nextPoint, umbrella);
                if (nextNode.isGameOver() || nextNode.isSmallerThenCost(maxOfSumHpAndUmbrellas)) {
                    continue;
                }
                nextNode.updateMinCounts(maxOfSumHpAndUmbrellas);
                queue.add(nextNode);
            }
        }
        if (minCount != Integer.MAX_VALUE) {
            return minCount;
        }
        throw new NoSuchElementException("can't find safe point");
    }

    private static class Node {
        private final int hp;
        private final int umbrella;
        private final Point point;
        private final int count;

        public Node(int hp, int umbrella, Point point, int count) {
            this.hp = hp;
            this.umbrella = umbrella;
            this.point = point;
            this.count = count;
        }

        private Node moveOnce(int[][] map, Point movedPoint, int umbrella) {
            int nextCount = count + 1;
            if (movedPoint.isSafe(map)) {
                return new Node(hp, this.umbrella, movedPoint, nextCount);
            }
            if (movedPoint.isUmbrella(map)) {
                return new Node(hp, umbrella - 1, movedPoint, nextCount);
            }
            if (this.umbrella > 0) {
                return new Node(hp, this.umbrella - 1, movedPoint, nextCount);
            }
            return new Node(hp - 1, this.umbrella, movedPoint, nextCount);
        }

        public boolean isGameOver() {
            return hp <= 0;
        }

        public boolean isSmallerThenCost(int[][] maxCosts) {
            return this.point.getValueInMap(maxCosts) >= hp + umbrella;
        }

        public void updateMinCounts(int[][] minCosts) {
            this.point.fillValue(minCosts, this.hp + this.umbrella);
        }
    }
}
