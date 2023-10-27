// prob: https://www.acmicpc.net/problem/19583

package backjoon.back19583;

import java.time.LocalTime;

public class Log {
    private final String name;
    private final LocalTime time;

    public Log(String name, LocalTime time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public LocalTime getTime() {
        return time;
    }

}
