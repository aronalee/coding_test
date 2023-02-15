// prob: https://www.acmicpc.net/problem/16928

package backjoon.back16928;

public class Ladder implements Step {

    private final int src;
    private final int dst;

    private Ladder(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }

    public static Ladder of(int src, int dst) {
        return new Ladder(src, dst);
    }

    public int getSrc() {
        return src;
    }

    public int getDst() {
        return dst;
    }
}
