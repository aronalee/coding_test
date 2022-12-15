package backjoon.back17387;

public class Back17387 {

    private final long[][] line1;
    private final long[][] line2;

    public Back17387(final long[][] line1, final long[][] line2) {
        this.line1 = line1;
        this.line2 = line2;
    }

    public int getAnswer() {
        long ccw1ByLine1 = createCCW(line1[0], line1[1], line2[0]);
        long ccw2ByLine1 = createCCW(line1[0], line1[1], line2[1]);
        long ccw1ByLine2 = createCCW(line2[0], line2[1], line1[0]);
        long ccw2ByLine2 = createCCW(line2[0], line2[1], line1[1]);
        if (ccw1ByLine1 * ccw2ByLine1 == 0 && ccw1ByLine2 * ccw2ByLine2 == 0) {
            if (isOverLap()) {
                return 1;
            }
            return 0;
        }
        if (ccw1ByLine1 * ccw2ByLine1 <= 0 && ccw1ByLine2 * ccw2ByLine2 <= 0) {
            return 1;
        }
        return 0;
    }

    private long createCCW(final long[] point1, final long[] point2, final long[] point3) {
        long tmp = (point1[0] * point2[1] + point2[0] * point3[1] + point3[0] * point1[1])
            - (point2[0] * point1[1] + point3[0] * point2[1] + point1[0] * point3[1]);
        if (tmp > 0) {
            return 1;
        } else if (tmp < 0) {
            return -1;
        }
        return 0;
    }

    private boolean isOverLap() {
        long x1 = line1[0][0];
        long y1 = line1[0][1];
        long x2 = line1[1][0];
        long y2 = line1[1][1];
        long x3 = line2[0][0];
        long y3 = line2[0][1];
        long x4 = line2[1][0];
        long y4 = line2[1][1];
        return
            Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
                && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2);
    }
}
