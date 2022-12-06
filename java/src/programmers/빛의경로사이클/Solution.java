// prob: https://school.programmers.co.kr/learn/courses/30/lessons/86052

package programmers.빛의경로사이클;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum DIRECTION {
    UP(0, new Point(1, 0)),
    LEFT(1, new Point(0, -1)),
    DOWN(2, new Point(-1, 0)),
    RIGHT(3, new Point(0, 1)),
    ;
    private final int id;
    private final Point point;

    DIRECTION(final int id, final Point point) {
        this.id = id;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public Point getPoint() {
        return point;
    }
}

enum MIRROR {
    S,
    L,
    R,
    ;

    public DIRECTION reflectingDirection(final DIRECTION input) {
        return switch (this) {
            case L -> switch (input) {
                case UP -> DIRECTION.LEFT;
                case LEFT -> DIRECTION.DOWN;
                case DOWN -> DIRECTION.RIGHT;
                case RIGHT -> DIRECTION.UP;
            };
            case R -> switch (input) {
                case UP -> DIRECTION.RIGHT;
                case LEFT -> DIRECTION.UP;
                case DOWN -> DIRECTION.LEFT;
                case RIGHT -> DIRECTION.DOWN;
            };
            case S -> input;
        };
    }
}

class Point {

    private final int y;
    private final int x;

    public Point(final int y, final int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Point getNextPoint(final List<List<MIRROR>> mirrors, final DIRECTION direction) {
        Point directionPoint = direction.getPoint();
        int nextY = this.y + directionPoint.getY();
        int nextX = this.x + directionPoint.getX();
        if (nextY < 0) {
            nextY = mirrors.size() - 1;
        } else if (nextY >= mirrors.size()) {
            nextY = 0;
        }
        if (nextX < 0) {
            nextX = mirrors.get(nextY).size() - 1;
        } else if (nextX >= mirrors.get(nextY).size()) {
            nextX = 0;
        }
        return new Point(nextY, nextX);
    }
}

public class Solution {

    public int[] solution(String[] grid) {
        List<List<MIRROR>> mirrors = new ArrayList<>();
        for (final String subGrid : grid) {
            List<MIRROR> subMirrors = new ArrayList<>();
            for (final char inputCurve : subGrid.toCharArray()) {
                MIRROR mirror = switch (inputCurve) {
                    case 'S' -> MIRROR.S;
                    case 'L' -> MIRROR.L;
                    case 'R' -> MIRROR.R;
                    default -> throw new IllegalArgumentException();
                };
                subMirrors.add(mirror);
            }
            mirrors.add(subMirrors);
        }
        List<Integer> results = searchAllMirror(mirrors);
        return convertListToAnswers(results);
    }

    private List<Integer> searchAllMirror(List<List<MIRROR>> mirrors) {
        boolean[][][] visited = new boolean[mirrors.size()][mirrors.get(0).size()][4];
        List<Integer> countsCycleRoute = new ArrayList<>();
        for (int i = 0; i < mirrors.size(); i++) {
            for (int j = 0; j < mirrors.get(i).size(); j++) {
                for (final DIRECTION direction : DIRECTION.values()) {
                    int count = countLightInCycle(mirrors, new Point(i, j), direction, visited);
                    if (count == 0) {
                        continue;
                    }
                    countsCycleRoute.add(count);
                }
            }
        }
        return countsCycleRoute;
    }

    private int countLightInCycle(final List<List<MIRROR>> mirrors, final Point start,
        final DIRECTION startDirection, boolean[][][] visited) {
        DIRECTION direction = startDirection;
        Point point = start;
        int count = 0;
        while (!visited[point.getY()][point.getX()][direction.getId()]) {
            visited[point.getY()][point.getX()][direction.getId()] = true;
            direction = mirrors.get(point.getY()).get(point.getX())
                .reflectingDirection(direction);
            point = point.getNextPoint(mirrors, direction);
            count++;
        }
        return count;
    }

    private int[] convertListToAnswers(List<Integer> results) {
        int[] answer = new int[results.size()];
        Collections.sort(results);
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }
}
