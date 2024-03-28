// prob: https://www.acmicpc.net/problem/18311

package backjoon.back18311;

public class Course {
    private final int id;
    private final long start;
    private final long end;

    public Course(int id, long start, long end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public int getId() {
        return this.id;
    }
}
