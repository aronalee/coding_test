package backjoon.back1374;

public class Course {

    private final int id;
    private final int startedAt;
    private final int endedAt;

    private Course(int id, int startedAt, int endedAt) {
        this.id = id;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }

    public static Course of(int id, int startedAt, int endedAt) {
        return new Course(id, startedAt, endedAt);
    }

    public int getId() {
        return id;
    }

    public int getStartedAt() {
        return startedAt;
    }

    public int getEndedAt() {
        return endedAt;
    }
}
