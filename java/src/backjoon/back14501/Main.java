// prob: https://www.acmicpc.net/problem/14501

package backjoon.back14501;

import java.io.*;

class Schedule {
    private final int time;
    private final int cost;

    public Schedule(int time, int cost) {
        this.time = time;
        this.cost = cost;
    }

    public int getTime() {
        return time;
    }

    public int getCost() {
        return cost;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Schedule[] schedules = new Schedule[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] tmp = reader.readLine().split(" ");
            int time = Integer.parseInt(tmp[0]);
            int cost = Integer.parseInt(tmp[1]);
            schedules[i] = new Schedule(time, cost);
        }
        int[] m = new int[n + 2];
        for (int i = n; i > 0; i--) {
            Schedule schedule = schedules[i];
            if (schedule.getTime() == 1) {
                m[i] = m[i + 1] + schedule.getCost();
            } else if (i + schedule.getTime() - 1 > n) {
                m[i] = m[i + 1];
            } else {
                m[i] = Math.max(m[i + 1], m[i + schedule.getTime()] + schedule.getCost());
            }
        }
        writer.write(m[1] + "\n");
        writer.flush();
    }
}
