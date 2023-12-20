// prob: https://www.acmicpc.net/problem/15806

package backjoon.back15806;

import java.util.*;

public class Back15806 {
    private static final int[][] DIRECTIONS = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    private final int maxRoomSizeY;
    private final int maxRoomSizeX;
    private final Set<Point> pointsOfValidate;

    public Back15806(int maxRoomSizeY, int maxRoomSizeX, Set<Point> pointsOfValidate) {
        this.maxRoomSizeY = maxRoomSizeY;
        this.maxRoomSizeX = maxRoomSizeX;
        this.pointsOfValidate = pointsOfValidate;
    }

    public boolean validateCleaning(List<Point> molds, int t) {
        Queue<Mold> queue = new LinkedList<>();
        Set<Mold> visited = new HashSet<>();
        for (Point pointOfMolds : molds) {
            spreadMolds(0, new Mold(pointOfMolds, 0), visited, queue);
        }
        while (!queue.isEmpty()) {
            Mold mold = queue.remove();
            if (t % 2 == mold.time % 2 && isValidate(mold.point)) {
                return true;
            }
            spreadMolds(t, mold, visited, queue);
        }
        return false;
    }

    private void spreadMolds(int t, Mold mold, Set<Mold> visited, Queue<Mold> queue) {
        for (int[] direction : DIRECTIONS) {
            int nextY = mold.point.getY() + direction[0];
            int nextX = mold.point.getX() + direction[1];
            if (nextY < 1 || nextY > maxRoomSizeY || nextX < 1 || nextX > maxRoomSizeX) {
                continue;
            }
            if (mold.time > t) {
                continue;
            }
            Mold nextMold = new Mold(Point.of(nextY, nextX), mold.time + 1);
            if (visited.contains(nextMold)) {
                continue;
            }
            visited.add(nextMold);
            queue.add(nextMold);
        }
    }

    public boolean isValidate(Point point) {
        return pointsOfValidate.contains(point);
    }

    private static class Mold {
        private final Point point;
        private final int time;

        public Mold(Point point, int time) {
            this.point = point;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Mold mold = (Mold) o;
            return time % 2 == mold.time % 2 && Objects.equals(point, mold.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point, time % 2);
        }
    }
}
