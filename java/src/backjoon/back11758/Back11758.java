// prob: https://www.acmicpc.net/problem/11758

package backjoon.back11758;

public class Back11758 {

    private final int[] point1;
    private final int[] point2;
    private final int[] point3;

    public Back11758(final int[] point1, final int[] point2, final int[] point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public int getAnswer() {
        int ccw = getCcw();
        if (ccw > 0) {
            return 1;
        } else if (ccw < 0) {
            return -1;
        }
        return 0;
    }

    private int getCcw() {
        return (point1[0] * point2[1] + point2[0] * point3[1] + point3[0] * point1[1])
            - (point2[0] * point1[1] + point3[0] * point2[1] + point1[0] * point3[1]);
    }
}
