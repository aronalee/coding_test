// prob: https://www.acmicpc.net/problem/16928

package backjoon.back16928;

public class Snake implements Step {

    private final int src;
    private final int dst;

    private Snake(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }

    public static Snake of(int src, int dst) {
        return new Snake(src, dst);
    }

    public int getSrc() {
        return src;
    }

    public int getDst() {
        return dst;
    }
}
