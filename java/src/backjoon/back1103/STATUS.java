// prob: https://www.acmicpc.net/problem/1103

package backjoon.back1103;

public enum STATUS {
    HOLE(-1),
    EMPTY(0),
    CYCLE(Integer.MAX_VALUE),
    ;
    private final int value;

    STATUS(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
