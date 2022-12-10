// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12952

package programmers.nqueen;

class Visitor {

    private final int n;
    private final boolean[] visitedWidth;
    private final boolean[] visitedHeight;
    private final boolean[] visitedAcs;
    private final boolean[] visitedDesc;

    public Visitor(final int n) {
        this.n = n;
        this.visitedWidth = new boolean[n];
        this.visitedHeight = new boolean[n];
        this.visitedAcs = new boolean[n * 2 + 1];
        this.visitedDesc = new boolean[n * 2 + 1];
    }

    public void checkPoint(final int y, final int x) {
        visitedHeight[y] = true;
        visitedWidth[x] = true;
        visitedAcs[x - y + n] = true;
        visitedDesc[x + y] = true;
    }

    public void unCheckPoint(final int y, final int x) {
        visitedHeight[y] = false;
        visitedWidth[x] = false;
        visitedAcs[x - y + n] = false;
        visitedDesc[x + y] = false;
    }

    public boolean isChecked(final int y, final int x) {
        return visitedHeight[y]
            || visitedWidth[x]
            || visitedAcs[x - y + n]
            || visitedDesc[x + y];
    }
}

public class Solution {

    private int answer = 0;
    private int end;

    public int solution(int n) {
        end = n;
        for (int x = 0; x < n; x++) {
            tracking(new Visitor(n), 0, x);
        }
        return answer;
    }

    private void tracking(final Visitor visitor, final int y, final int x) {
        visitor.checkPoint(y, x);
        int nextY = y + 1;
        if (nextY == end) {
            answer++;
            return;
        }
        for (int nextX = 0; nextX < end; nextX++) {
            if (visitor.isChecked(nextY, nextX)) {
                continue;
            }
            tracking(visitor, nextY, nextX);
            visitor.unCheckPoint(nextY, nextX);
        }
    }
}
